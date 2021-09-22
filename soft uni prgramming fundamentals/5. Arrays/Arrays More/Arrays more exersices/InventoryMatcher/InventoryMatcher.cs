using System;
using System.Linq;

namespace InventoryMatcher
{
    class InventoryMatcher
    {
        static void Main(string[] args)
        {
            string[] nameProducts = Console.ReadLine().Split().ToArray();
            long[] quantities = Console.ReadLine().Split().Select(long.Parse).ToArray();
            string[] price = Console.ReadLine().Split().ToArray();

            string name = Console.ReadLine();
            while (name != "done")
            {
                for (int i = 0; i < nameProducts.Length; i++)
                {
                    if (name == nameProducts[i])
                    {
                        Console.WriteLine($"{nameProducts[i]} costs: {price[i]}; Available quantity: {quantities[i]}");
                    }
                }
                name = Console.ReadLine();
            }
        }
    }
}
