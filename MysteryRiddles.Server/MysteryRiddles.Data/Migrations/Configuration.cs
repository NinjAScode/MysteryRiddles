namespace MysteryRiddles.Data.Migrations
{
    using System.Data.Entity.Migrations;
    using System.Linq;

    public sealed class Configuration : DbMigrationsConfiguration<MysteryRiddles.Data.MysteryRiddlesDbContext>
    {
        private DataSeeder seeder;

        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
            AutomaticMigrationDataLossAllowed = false;
            this.seeder = new DataSeeder();
        }

        protected override void Seed(MysteryRiddles.Data.MysteryRiddlesDbContext context)
        {
            if (context.Riddles.Any())
            {
                return;
            }

            this.seeder.SeedRiddles(context);
        }
    }
}
