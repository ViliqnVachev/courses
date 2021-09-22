using System;
using System.Collections.Generic;
using System.Linq;

namespace _004Problem
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, List<string>> light = new Dictionary<string, List<string>>();
            Dictionary<string, List<string>> dark = new Dictionary<string, List<string>>();

            int count = 0;
            while (true)
            {
                string line = Console.ReadLine();

                if (line == "Lumpawaroo")
                {
                    break;
                }
                string name = "";
                string side = "";

                if (count == 0)
                {
                    var helped = new List<string>();
                    helped.Add(name);
                    light.Add(side, helped);
                }

                if (line.Contains("|"))
                {
                    string[] data = line.Split('|');

                    name = data[1].TrimStart();
                    side = data[0];

                    if (light.ContainsKey(side))
                    {
                        if (light[side].Contains(name) == false)
                        {

                            light[side].Add(name);
                        }

                    }
                    else
                    {
                        if (dark.ContainsKey(side) == false)
                        {
                            var helper = new List<string>();
                            helper.Add(name);
                            dark.Add(side, helper);
                        }
                        else
                        {
                            if (dark[side].Contains(name) == false)
                            {

                                dark[side].Add(name);
                            }
                        }
                    }

                }
                else
                {
                    string[] data = line.Split("->");
                    name = data[0].TrimStart();
                    side = data[1].Trim();

                    if (light[side].Contains(name) == false)
                    {
                        if (dark[side].Contains(name))
                        {
                            light[side].Add(name);
                            dark[side].Remove(name);

                        }
                        else
                        {
                            light[side].Add(name);
                            Console.WriteLine($"{name} joins the {side} side!");
                        }

                    }
                    else if (dark[side].Contains(name) == false)
                    {


                        if (light[side].Contains(name))
                        {
                            dark[side].Add(name);
                            light[side].Remove(name);

                        }
                        else
                        {
                            dark[side].Add(name);
                            Console.WriteLine($"{name} joins the {side} side!");
                        }
                    }
                }

                count++;
            }

            foreach (var item in light.OrderByDescending(x => x.Value.Count()))
            {
                Console.WriteLine($"Side: {item.Key}, Members: {item.Value.Count()}");
                foreach (var ls in item.Value)
                {
                    Console.WriteLine($"! {ls}");
                }
            }

            foreach (var item in dark.OrderByDescending(x => x.Value.Count()))
            {
                Console.WriteLine($"Side: {item.Key}, Members: {item.Value.Count()}");
                foreach (var ls in item.Value)
                {
                    Console.WriteLine($"! {ls}");
                }
            }
        }
        

    }
}
