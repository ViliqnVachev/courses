using System;
using System.Linq;

namespace UpgradedMatcher
{
    class UpgradedMatcher
    {
        static void Main(string[] args)
        {
            string[] nameProducts = Console.ReadLine().Split().ToArray();

            long[] quantitiesInput = Console.ReadLine().Split().Select(long.Parse).ToArray();
            long[] quantities = new long[nameProducts.Length];
            for (int i = 0; i < quantitiesInput.Length; i++)
            {
                quantities[i] = quantitiesInput[i];
            }


            double[] price = Console.ReadLine().Split().Select(double.Parse).ToArray();

            string[] comand = Console.ReadLine().Split().ToArray(); 
            while (comand[0] != "done")
            {
                string name = comand[0];
                long quan = long.Parse(comand[1]);

                for (int i = 0; i < nameProducts.Length; i++)
                {
                    if (name == nameProducts[i])
                    {
                        if (quan <= quantities[i])
                        {
                            Console.WriteLine($"{nameProducts[i]} x {quan} costs {price[i] * quan:f2}");
                            quantities[i] -= quan;
                        }
                        else
                        {
                            Console.WriteLine($"We do not have enough {nameProducts[i]}");
                            break;
                        }
                    }
                   
                }
                comand = Console.ReadLine().Split().ToArray(); 
            }
        }
    }
}
