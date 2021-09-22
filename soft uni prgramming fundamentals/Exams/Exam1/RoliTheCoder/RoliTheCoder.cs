using System;
using System.Collections.Generic;
using System.Linq;

namespace RoliTheCoder
{
    class RoliTheCoder
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();

            Dictionary<int, Dictionary<string, List<string>>> output = new Dictionary<int, Dictionary<string, List<string>>>();

            while (input[0] != "Time")
            {
                int id=int.Parse(input[0]);
                string events=input[1];

                if (!events.StartsWith("#"))
                {
                    input = Console.ReadLine().Split().ToArray();
                    continue;
                }

                if (output.ContainsKey(id) == false)
                {
                    var helpDic = new Dictionary<string, List<string>>();
                    var helList = new List<string>();
                    for (int i = 2; i < input.Length; i++)
                    {
                        helList.Add(input[i]);
                    }
                    helpDic.Add(events, helList);

                    output.Add(id, helpDic);
                }
                else
                {
                    if (output[id].ContainsKey(events)==false)
                    {
                        input = Console.ReadLine().Split().ToArray();
                        continue;
                    }
                    else
                    {
                        List<string> helpList = new List<string>();
                        for (int i =2 ; i < input.Length; i++)
                        {
                            helpList.Add(input[i]);
                        }
                        output[id][events].AddRange(helpList);
                        output[id][events]= output[id][events].Distinct().OrderBy(n=>n).ToList();
                    }
                }
                input = Console.ReadLine().Split().ToArray();
            }
            foreach (var item in output.OrderByDescending(x=>x.Value.Values.Count()))
            {
                int id = item.Key;
                var allevents = item.Value.OrderByDescending(x=>x.Value.Count);
                Console.WriteLine($"{item.Value.Count}");

                foreach (var ev in allevents)
                {
                    Console.WriteLine($"{ev.Key.Trim('#')} - {ev.Value.Count}");
                    foreach (var names in ev.Value.OrderBy(n=>n))
                    {
                        Console.WriteLine(names);
                    }
                }
            }
        }
    }
}
