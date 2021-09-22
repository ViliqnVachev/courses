using System;
using System.Collections.Generic;
using System.Linq;

namespace PopulationCounter
{
    class PopulationCounter
    {
        static void Main(string[] args)
        {
            string[] intput = Console.ReadLine().Split('|').ToArray();
            Dictionary<string, Dictionary<string, long>> report = new Dictionary<string, Dictionary<string, long>>();
            while (intput[0] != "report")
            {
                string city=intput[0];
                string country=intput[1];
                int popolation= int.Parse(intput[2]);

                if (report.ContainsKey(country) == false)
                {
                    Dictionary<string, long> cities = new Dictionary<string, long>();
                    if (cities.ContainsKey(city) == false)
                    {
                        cities.Add(city, popolation);
                    }
                    else
                    {
                        cities[city] = popolation;
                    }
                    report.Add(country, cities);
                }
                else
                {
                    if(report[country].ContainsKey(city)==false)
                    {
                        report[country].Add(city, popolation);
                    }
                   
                    
                }
                intput = Console.ReadLine().Split('|').ToArray();

            }
            foreach (var count in report.OrderByDescending(x=>x.Value.Values.Sum()) )
            {
                Console.WriteLine(value: $"{count.Key} (total population: {count.Value.Values.Sum()})");
                foreach (var item in count.Value.OrderByDescending(x=>x.Value))
                {
                    Console.WriteLine($"=>{item.Key}: {item.Value}");
                }
            }
        }
    }
}
