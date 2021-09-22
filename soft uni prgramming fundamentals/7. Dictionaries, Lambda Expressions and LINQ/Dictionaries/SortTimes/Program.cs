using System;
using System.Collections.Generic;
using System.Linq;

namespace SortTimes
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> time = Console.ReadLine().Split().ToList();
            time = time.OrderBy(x => x).ToList();
            Console.WriteLine(String.Join(", ",time));
        }
    }
}
