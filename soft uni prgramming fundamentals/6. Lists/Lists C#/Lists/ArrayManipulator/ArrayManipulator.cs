using System;
using System.Collections.Generic;
using System.Linq;

namespace ArrayManipulator
{
    class ArrayManipulator
    {
        static void Main(string[] args)
        {
            List<int> inputNumbers = Console.ReadLine().Split().Select(int.Parse).ToList();

            string[] comands = Console.ReadLine().Split().ToArray();

            while (comands[0] != "print")
            {
                if (comands[0] == "add")
                {
                    int index = int.Parse(comands[1]);
                    int element = int.Parse(comands[2]);

                    inputNumbers.Insert(index, element);
                }
                else if (comands[0] == "addMany")
                {
                    int index = int.Parse(comands[1]);
                    inputNumbers.InsertRange(index, comands.Skip(2).Select(int.Parse));
                }
                else if (comands[0] == "contains")
                {
                    int element = int.Parse(comands[1]);
                    if (inputNumbers.Contains(element))
                    {
                        Console.WriteLine(inputNumbers.IndexOf(element));
                    }
                    else
                    {
                        Console.WriteLine(-1);
                    }
                }
                else if (comands[0] == "remove")
                {
                    int index = int.Parse(comands[1]);
                    inputNumbers.RemoveAt(index);
                }
                else if (comands[0] == "shift")
                {
                    int position = int.Parse(comands[1])%inputNumbers.Count();

                    List<int> helper = inputNumbers.Skip(position).ToList();
                    
                    for (int i = 0; i < position; i++)
                    {
                        helper.Add(inputNumbers[i]);
                    }
                    inputNumbers = helper;
                }
                else if (comands[0] == "sumPairs")
                {
                    int lenght = inputNumbers.Count()/2;
                   
                    for (int i = 0; i < lenght ; i++)
                    {
                        inputNumbers[i]+=inputNumbers[i + 1];
                        inputNumbers.RemoveAt(i + 1);
                        
                    }
                    
                }
                comands = Console.ReadLine().Split().ToArray();
            }

            if (comands[0] == "print")
            {
                Console.WriteLine("[" + string.Join(", ", inputNumbers) + "]");
            }
        }
    }
}
