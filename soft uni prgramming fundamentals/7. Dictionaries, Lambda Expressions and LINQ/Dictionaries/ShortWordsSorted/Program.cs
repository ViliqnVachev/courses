using System;
using System.Collections.Generic;
using System.Linq;

namespace ShortWordsSorted
{
    class Program
    {
        static void Main(string[] args)
        {
            string []input = Console.ReadLine().ToLower()
                .Split(".,:;()[]\"'\\/!? ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries)
                .OrderBy(num=>num)
                .Where(a=>a.Length<5)
                .Distinct()
                .ToArray();

            Console.WriteLine(String.Join(", ",input));
            
               
        }
    }
}
