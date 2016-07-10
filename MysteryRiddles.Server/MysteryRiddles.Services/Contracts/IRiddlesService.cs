namespace MysteryRiddles.Services.Contracts
{
    using Models;
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Threading.Tasks;

    public interface IRiddlesService
    {
        IQueryable<Riddle> GetAll();

        Riddle GetById(int id);

        Riddle GetRandom();
    }
}
