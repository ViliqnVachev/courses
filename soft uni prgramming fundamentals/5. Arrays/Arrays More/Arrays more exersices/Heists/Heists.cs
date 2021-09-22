using System;
using System.Linq;

namespace Heists
{
    class Heists
    {
        static void Main(string[] args)
        {
            string[] price = Console.ReadLine().Split().ToArray();
            int jewelsPrice = int.Parse(price[0]);
            int goldPrice = int.Parse(price[1]);

            string[] information = Console.ReadLine().Split().ToArray();
            int countJewels = 0;
            int countGold = 0;
            int expenses = 0;

            while (information[0]!= "Jail")
            {
                string loot = information[0];
                int heistExpenses  = int.Parse(information[1]);

                for (int i = 0; i < loot.Length; i++)
                {
                    if (loot[i] == '%')
                    {
                        countJewels++;
                    }else if(loot[i] == '$')
                    {
                        countGold++;
                    }
                }
                expenses += heistExpenses;
                information = Console.ReadLine().Split().ToArray();
            }

            long earning = (jewelsPrice * countJewels) + (goldPrice * countGold);
            if (earning >= expenses)
            {
                Console.WriteLine($"Heists will continue. Total earnings: {earning-expenses}.");
            }
            else
            {
                Console.WriteLine($"Have to find another job. Lost: {expenses-earning}.");
            }

        }
    }
}
