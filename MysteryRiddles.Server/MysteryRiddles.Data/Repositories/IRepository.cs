﻿using System.Linq;

namespace MysteryRiddles.Data.Repositories
{
    public interface IRepository<T>
    {
        IQueryable<T> All();

        T GetById(object id);

        void Add(T entity);

        void Update(T entity);

        T Delete(T entity);

        T Delete(object id);

        void Detach(T entity);

        int SaveChanges();
    }
}
