namespace MysteryRiddles.Controllers
{
    using AutoMapper.QueryableExtensions;
    using Models.Riddles;
    using Services.Contracts;
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Net;
    using System.Net.Http;
    using System.Web.Http;

    public class RiddlesController : ApiController
    {
        private IRiddlesService riddlesService;

        public RiddlesController(IRiddlesService riddlesService)
        {
            this.riddlesService = riddlesService;
        }

        public IHttpActionResult Get()
        {
            var allRiddles = this.riddlesService
                .GetAll()
                .ProjectTo<RiddlesResponseViewModel>();

            return Ok(allRiddles);
        }

        public IHttpActionResult Get(int id)
        {
            var riddle = this.riddlesService.GetById(id);

            if (riddle == null)
            {
                return BadRequest("Riddle does not exist.");
            }

            var dispalyModel = AutoMapper.Mapper.Map<RiddlesResponseViewModel>(riddle);
            return Ok(dispalyModel);
        }

        public IHttpActionResult GetRandom()
        {
            var riddle = this.riddlesService.GetRandom();

            if (riddle == null)
            {
                return BadRequest("No riddles found.");
            }

            var dispalyModel = AutoMapper.Mapper.Map<RiddlesResponseViewModel>(riddle);
            return Ok(dispalyModel);
        }
    }
}