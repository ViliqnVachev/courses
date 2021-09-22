using System;
using System.Collections.Generic;
using System.Linq;

namespace Snowmen
{
    class Snowmen
    {
        static void Main(string[] args)
        {
            List<int> snowmens = Console.ReadLine().Split().Select(int.Parse).ToList();

            while (snowmens.Count > 1)
            {

                List<int> winers = new List<int>();
                List<int> loseIdex = new List<int>();

                for (int atackIndex = 0; atackIndex < snowmens.Count; atackIndex++)
                {
                    int targetIndex = snowmens[atackIndex];

                    if (snowmens.Count - loseIdex.Count == 1)
                    {
                        break;
                    }

                    if (loseIdex.Contains(atackIndex))
                    {
                        continue;
                    }

                    if (targetIndex >= snowmens.Count)
                    {
                        targetIndex = targetIndex % snowmens.Count;
                    }

                    int difference = Math.Abs(atackIndex - targetIndex);

                    if (atackIndex == targetIndex)
                    {
                        Console.WriteLine($"{atackIndex} performed harakiri");
                        loseIdex.Add(atackIndex);
                        snowmens[atackIndex] = -1;
                        continue;
                    }

                    if (difference % 2 == 0)
                    {
                        Console.WriteLine($"{atackIndex} x {targetIndex} -> {atackIndex} wins");
                        loseIdex.Add(targetIndex);
                        snowmens[targetIndex] = -1;
                    }
                    else if (difference % 2 != 0)
                    {
                        Console.WriteLine($"{atackIndex} x {targetIndex} -> {targetIndex} wins");
                        loseIdex.Add(atackIndex);
                        snowmens[atackIndex] = -1;
                    }

                    loseIdex = loseIdex.Distinct().ToList();


                }
                snowmens = snowmens.Where(s=>s>0).ToList();

            }
        }
    }
}

