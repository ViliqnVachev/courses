using System;

namespace _01._Sweet_Dessert
{
    class SweetDessert
    {
        static void Main(string[] args)
        {
            


            // products per portion
           
            
            

            decimal ivnachosMoney = decimal.Parse(Console.ReadLine());
            decimal numberOfGuests = decimal.Parse(Console.ReadLine());
            numberOfGuests = numberOfGuests * 1.0m;
            double priceOfBannana = double.Parse(Console.ReadLine());
            double priceOfegg = double.Parse(Console.ReadLine());
            double priceOfBerriesfForAKilo = double.Parse(Console.ReadLine());

            int portion = (int)Math.Ceiling(numberOfGuests / 6);

            long deserts = 6 * portion;

            int egg = 4*portion;
            int bannas = 2*portion;
            double berries = 0.2*portion;

            decimal bill =(decimal) ((egg * priceOfegg) + (priceOfBannana * bannas) + (berries * priceOfBerriesfForAKilo));

            if (bill > ivnachosMoney)
            {
                decimal neede = bill - ivnachosMoney;
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {neede:F2}lv more.");
            }
            else
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {bill:F2}lv.");
            }

        }
    }
}
