using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace _03._Rage_Quit
{
    class RageQuit
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToUpper();
            string patern = @"([\D]+)([\d]+)";
            List<char> symbols = new List<char>();

            var match = Regex.Matches(input, patern);
            StringBuilder sb = new StringBuilder();
            foreach (Match item in match)
            {
                string word = item.Groups[1].Value;
                int repeat = int.Parse(item.Groups[2].Value);

                for (int i = 0; i < repeat; i++)
                {
                sb.Append(word);
                }
            }
            symbols.AddRange(sb.ToString());
            symbols = symbols.Distinct().ToList();

            Console.WriteLine($"Unique symbols used: {symbols.Count}");
            Console.WriteLine(sb);
        }
    }
}
