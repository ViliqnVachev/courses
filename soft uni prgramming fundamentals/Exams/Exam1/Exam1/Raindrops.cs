using System;
using System.Linq;

namespace Exam1
{
    class Raindrops
    {
        static void Main(string[] args)
        {
            int region = int.Parse(Console.ReadLine());
            decimal density = decimal.Parse(Console.ReadLine());
            decimal sum = 0M;

            for (int i = 0; i < region; i++)
            {
                string[] data = Console.ReadLine().Split().ToArray();
                long raindropsCount = long.Parse(data[0]);
                int squareMeters = int.Parse(data[1]);

                sum += (raindropsCount / (decimal)squareMeters);

            }
            if (density != 0)
            {
                sum = sum / density;
            }
            Console.WriteLine($"{sum:f3}");
        }
    }
}
