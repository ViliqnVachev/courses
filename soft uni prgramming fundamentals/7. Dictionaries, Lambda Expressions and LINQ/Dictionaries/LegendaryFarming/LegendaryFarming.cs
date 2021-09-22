using System;
using System.Collections.Generic;
using System.Linq;

namespace LegendaryFarming
{
    class LegendaryFarming
    {
        static void Main(string[] args)
        {
           
            Dictionary<string, int> resources = new Dictionary<string, int>();
            resources.Add("shards", 0);
            resources.Add("fragments", 0);
            resources.Add("motes", 0);
            Dictionary<string, int> junk = new Dictionary<string, int>();
            bool isShadowmourne = false;
            bool isValanyr = false;
            bool isDragonwrath = false;
            while(isShadowmourne == false && isValanyr == false && isDragonwrath == false)
            {
                List <string>input = Console.ReadLine().ToLower().Split().ToList();
                for (int i = 0; i < input.Count; i++)
                {
                    int quantity = int.Parse(input[i]);
                    input.RemoveAt(i);
                    string material = input[i];
                    input.RemoveAt(i);
                    i--;
                    if (resources.ContainsKey(material)){
                        resources[material] += quantity;
                    }
                    else
                    {
                        if (junk.ContainsKey(material) == false)
                        {
                            junk.Add(material, quantity);
                        }
                        else
                        {
                            junk[material] += quantity;
                        }
                    }
                    if (resources["shards"] >= 250)
                    {
                        isShadowmourne = true;
                        resources["shards"] -= 250;
                        break;
                    }
                    else if (resources["fragments"] >= 250)
                    {
                        isValanyr = true;
                        resources["fragments"] -= 250;
                        break;
                    }
                    else if(resources["motes"] >= 250)
                    {
                        isDragonwrath = true;
                        resources["motes"] -= 250;
                        break;
                    }
                }
            }
            if (isShadowmourne)
            {
                Console.WriteLine("Shadowmourne obtained!");
            }else if (isValanyr)
            {
                Console.WriteLine("Valanyr obtained!");
            }
            else
            {
                Console.WriteLine("Dragonwrath obtained!");
            }
            foreach (var item in resources.OrderBy(z => z.Key).OrderByDescending(x=>x.Value))
            {
                Console.WriteLine($"{item.Key}: {item.Value}");
            }
            foreach (var item in junk.OrderBy(x=>x.Key))
            {
                Console.WriteLine($"{item.Key}: {item.Value}");
            }

        }
    }
}
