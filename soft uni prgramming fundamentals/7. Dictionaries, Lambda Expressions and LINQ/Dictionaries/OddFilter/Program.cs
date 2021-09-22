using System;
using System.Collections.Generic;
using System.Linq;

namespace OddFilter
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] intput = Console.ReadLine().Split().Select(int.Parse).ToArray();
            List<int> numbers = new List<int>();

            for (int i = 0; i < intput.Length; i++)
            {
                if (intput[i] % 2 == 0)
                {
                    numbers.Add(intput[i]);
                }
            }
            double average = numbers.Average();

            for (int i = 0; i < numbers.Count; i++)
            {
                if (numbers[i] > average)
                {
                    numbers[i] = numbers[i] + 1;
                }
                else
                {
                    numbers[i] = numbers[i] - 1;
                }
            }
            Console.WriteLine(string.Join(" ",numbers));
        }
    }
}
