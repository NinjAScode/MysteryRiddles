namespace MysteryRiddles.Data
{
    using System.Collections.Generic;

    using System.Data.Entity.Migrations;
    using MysteryRiddles.Models;

    public class DataSeeder
    {
        public void SeedRiddles(MysteryRiddlesDbContext context)
        {
            var riddles = new List<Riddle>
            {
                new Riddle()
                {
                    Title = "Мистър Браун в Лондон",
                    Description = @"В полунощ, в Лондон, в един влак, по коридора минава един човек.
Влиза в едно купе.
От купето се чува писък.
Влизат хора и виждат мъртва жена.
идва полиция. Разследват и хващат Мистър Браун.
Завеждат го в участъка и го разпитват.
Той им казва, че се казва Мистър Браун и... и го пускат.
Защо?",
                    Answer = "Жената е съпругата на мистър Браун, която преди години е инсценирала смъртта си и е набедила съпруга си. Той излежал присъдата си. След като я среща във влака я убива. Уловката е там, че не можеш да лежиш два пъти за едно престъпление."
                },
                new Riddle()
                {
                    Title = "Близнаци",
                    Description = "Митко и Данчо са близнаци, родени в Бургас през 1985г. Митко е бил роден преди Данчо, но според актовете им за раждане Данчо е по-стар от Митко, как така?",
                    Answer = "Митко и Данчо са зодия близнаци."
                },
            };

            context.Riddles.AddOrUpdate(riddles.ToArray());
            context.SaveChanges();
        }
    }
}
