namespace MysteryRiddles.App_Start
{
    using Data;
    using Data.Migrations;
    using System;
    using System.Collections.Generic;
    using System.Data.Entity;
    using System.Linq;
    using System.Web;

    public class DatabaseConfig
    {
        public static void Initialize()
        {
            Database.SetInitializer(new MigrateDatabaseToLatestVersion<MysteryRiddlesDbContext, Configuration>());
            MysteryRiddlesDbContext.Create().Database.Initialize(true);
        }
    }
}