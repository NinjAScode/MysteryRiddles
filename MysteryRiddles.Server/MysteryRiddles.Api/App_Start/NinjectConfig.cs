using System;
using System.Data.Entity;
using System.Reflection;
using Ninject;
using Ninject.Web.Common;
using MysteryRiddles.Data;
using MysteryRiddles.Data.Repositories;
using Ninject.Extensions.Conventions;

namespace MysteryRiddles.Api
{
    public class NinjectConfig
    {
        public static Lazy<IKernel> CreateKernel = new Lazy<IKernel>(() =>
        {
            var kernel = new StandardKernel();
            kernel.Load(Assembly.GetExecutingAssembly());

            RegisterServices(kernel);

            return kernel;
        });

        /// <summary>
        /// Load your modules or register your services here!
        /// </summary>
        /// <param name="kernel">The kernel.</param>
        private static void RegisterServices(IKernel kernel)
        {
            kernel.Bind(typeof(IRepository<>)).To(typeof(GenericRepository<>));
            kernel.Bind<DbContext>().To<MysteryRiddlesDbContext>().InRequestScope();
            kernel.Bind<IMysteryRiddlesDbContext>().To<MysteryRiddlesDbContext>();

            kernel.Bind(b => b.From("MysteryRiddles.Services").SelectAllClasses().BindDefaultInterface());
        }   
    }
}