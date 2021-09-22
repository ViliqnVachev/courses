using System;
using System.Collections.Generic;
using System.Linq;

namespace СръбскоUnleashed
{
    class СръбскоUnleashed
    {
        static void Main(string[] args)
        {
           

            List<string> input = Console.ReadLine().Split().ToList();
            Dictionary<string, Dictionary<string, long>> print = new Dictionary<string, Dictionary<string, long>>();

            while (input[0] != "End")
            {
                List<string> singerNames = new List<string>();
                int count = 0;
                for (int i = 0; i < 3; i++)
                {
                    if (!input[i].StartsWith('@'))
                    {
                        singerNames.Add(input[i]);
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
                List<string> city = input.Skip(count).Take(input.Count - count - 2).ToList();
                int people = int.Parse(input[input.Count - 1]);
                int price = int.Parse(input[input.Count - 2]);
                string concertCity="";
                for (int i = 0; i < city.Count; i++)
                {
                    if (city[i].StartsWith('@'))
                    {
                        city[i] = city[i].Remove(0, 1);
                    }
                    concertCity += city[i] + " ";
                }
            string singer = "";
            for (int i = 0; i < singerNames.Count; i++)
            {
                singer += singerNames[i] + " ";
            }
                if (print.ContainsKey(concertCity) == false)
                {                   
                    print.Add(concertCity, new Dictionary <string,long>());

                }
                if (print[concertCity].ContainsKey(singer)==false)
                {
                    print[concertCity].Add(singer, 0);
                }
                print[concertCity][singer] += people* price;
                input = Console.ReadLine().Split().ToList();
            }
            foreach (var item in print)
            {
                Console.WriteLine($"{item.Key}");
                foreach (var singer in item.Value)
                {
                    Console.WriteLine($"#  {singer.Key} -> {singer.Value}");
                }
            }
        }
    }
}
