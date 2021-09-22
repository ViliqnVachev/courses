using System;
using System.Collections.Generic;

namespace AMinerTask
{
    class AMinerTask
    {
        static void Main(string[] args)
        {
            Dictionary<string, int> resource = new Dictionary<string, int>();
            String comand = Console.ReadLine();
            string metal;
            int qunat;


            while (comand != "stop")
            {
                metal = comand;
                qunat = int.Parse(Console.ReadLine());

                if (resource.ContainsKey(metal) == false)
                {
                    resource.Add(metal, qunat);
                }
                else
                {
                    resource[metal] += qunat;
                }
                
                comand = Console.ReadLine();
            }

            foreach (var item in resource)
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");

            }
               
        }
    }
}
