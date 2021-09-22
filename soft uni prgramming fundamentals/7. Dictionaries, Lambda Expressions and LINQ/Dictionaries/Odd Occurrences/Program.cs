using System;
using System.Collections.Generic;
using System.Linq;

namespace Odd_Occurrences
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] words = Console.ReadLine().ToLower().Split().ToArray();

            var exit = new Dictionary<string, int>();

            foreach (var item in words)
            {
                if (exit.ContainsKey(item) == false)
                {
                    exit.Add(item, 0);
                }
                exit[item]++;

            }
            List<string> output = new List<string>();
            foreach (var item in exit){
                if (item.Value % 2 != 0)
                {
                    output.Add(item.Key);
                }
            }
            Console.WriteLine(string.Join(", ",output));
        }
    }
}

