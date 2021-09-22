using System;
using System.Globalization;

namespace _1.SoftUniCoffeeOrders
{
    class SoftUniCoffeeOrders
    {
        static void Main(string[] args)
        {
            int orders = int.Parse(Console.ReadLine());
            decimal total = 0M;
            for (int i = 0; i < orders; i++)
            {
                decimal pricePerCapsule = decimal.Parse(Console.ReadLine());
                string date = Console.ReadLine();
                DateTime dt = DateTime.ParseExact(date, "d/M/yyyy", CultureInfo.InvariantCulture);
                int daysInMonth = DateTime.DaysInMonth(dt.Year,dt.Month);
                long capsules = long.Parse(Console.ReadLine());

                decimal price = (daysInMonth * capsules) * pricePerCapsule;
                total += price;
                Console.WriteLine($"The price for the coffee is: ${price:F2}");
            }
            Console.WriteLine($"Total: ${total:F2}");
        }
    }
}
