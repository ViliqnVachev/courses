using System;
using System.Collections.Generic;
using System.Linq;

namespace Dictionaries
{
    class Program
    {
        static void Main(string[] args)
        {
           double[] input = Console.ReadLine()
                .Split()
                .Select(double.Parse)
                .ToArray();


            var count = new SortedDictionary<double, int>();

            foreach (var num in input)
            {
                if (count.ContainsKey(num)==false)
                {
                    count.Add(num, 0);
                }
                count[num]++;
            }

            foreach (var item in count)
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }
        }
    }
}
