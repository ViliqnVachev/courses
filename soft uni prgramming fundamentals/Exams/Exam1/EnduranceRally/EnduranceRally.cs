using System;
using System.Collections.Generic;
using System.Linq;

namespace EnduranceRally
{
    class EnduranceRally
    {
        static void Main(string[] args)
        {
            string[] participans = Console.ReadLine().Split().ToArray();
            double[] road = Console.ReadLine().Split().Select(double.Parse).ToArray();
            int[] zones = Console.ReadLine().Split().Select(int.Parse).ToArray();
            List<string> output = new List<string>();



            for (int racer = 0; racer < participans.Length; racer++)
            {
                char[] f = participans[racer].ToCharArray();
                double fuel=f[0];
                string temp = "";

                for (int i = 0; i < road.Length; i++)
                {
                    bool isCheckpoint = false;
                    for (int checkpoint = 0; checkpoint < zones.Length; checkpoint++)
                    {
                        if (i == zones[checkpoint])
                        {
                            
                            isCheckpoint = true;
                            break;
                        }
                    }
                    if (isCheckpoint == false)
                    {
                        fuel -= road[i];
                    }
                    else
                    {
                        fuel += road[i];
                    }
                    if (fuel <= 0)
                    {
                         temp = $"{participans[racer]} - reached {i}";
                        output.Add(temp);
                        break;
                    }

                }
                 if (fuel>0)
                {
                     temp = $"{participans[racer]} - fuel left {fuel:f2}";
                    output.Add(temp);
                }

            }
            for (int i = 0; i < output.Count; i++)
            {
                Console.WriteLine(output[i]);
            }
        }
    }
}
