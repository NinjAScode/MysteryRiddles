namespace MysteryRiddles.Services
{
    using Contracts;
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using Models;
    using Data;
    using Data.Repositories;
    public class RiddlesService : IRiddlesService
    {
        private IRepository<Riddle> riddlesRepository;
        private static Random random;

        static RiddlesService()
        {
            random = new Random();
        }

        public RiddlesService(IRepository<Riddle> riddlesRepository)
        {
            this.riddlesRepository = riddlesRepository;
        }

        public IQueryable<Riddle> GetAll()
        {
            return this.riddlesRepository
                .All()
                .OrderBy(x => x.CreatedOn);
        }

        public Riddle GetById(int id)
        {
            return this.riddlesRepository.GetById(id);
        }

        public Riddle GetRandom()
        {
            Riddle randomRiddle = this.riddlesRepository
                .All()
                .OrderBy(r => Guid.NewGuid())
                .FirstOrDefault();
            //do
            //{
            //    int count = this.riddlesRepository
            //        .All()
            //        .Count();

            //    int randomRiddleId = random.Next(1, count + 1);

            //    randomRiddle = this.riddlesRepository.GetById(randomRiddleId);
            //}
            //while (randomRiddle == null);

            return randomRiddle;
        }
    }
}
