using System;
using System.Linq;

namespace SumMinMaxAverage
{
    class Program
    {
        static void Main(string[] args)
        {
            int size = int.Parse(Console.ReadLine());

            double[] numbers = new double[size];

            for (int i = 0; i < numbers.Length; i++)
            {
                
                numbers[i] = double.Parse(Console.ReadLine());
            }

                

            Console.WriteLine($"Sum = {numbers.Sum()}");
            Console.WriteLine($"Min = {numbers.Min()}");
            Console.WriteLine($"Max = {numbers.Max()}");
            Console.WriteLine($"Average = {numbers.Average()}");

        }
    }
}
