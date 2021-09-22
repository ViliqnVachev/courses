using System;
using System.Collections.Generic;
using System.Linq;

namespace ChangeList
{
    class ChangeList
    {
        static void Main(string[] args)
        {
            List<int> list = Console.ReadLine().Split().Select(int.Parse).ToList();

            string[] comands = Console.ReadLine().Split().ToArray();

            while (comands[0] != "Odd" && comands[0] != "Even")
            {
                int index;
                int element;
                if (comands[0] == "Delete")
                {
                    element = int.Parse(comands[1]);
                    for (int i = 0; i < list.Count; i++)
                    {
                        if (list[i] == element)
                        {
                            list.Remove(element);
                            i--;
                        }
                    }
                }else if (comands[0] == "Insert")
                {
                    element = int.Parse(comands[1]);
                    index = int.Parse(comands[2]);
                    list.Insert(index, element);
                }
                comands = Console.ReadLine().Split().ToArray();
            }
            if (comands[0] == "Odd")
            {
                for (int i = 0; i < list.Count; i++)
                {
                    if (list[i] % 2 != 0)
                    {
                        Console.Write(list[i]+" ");
                    }
                }
                Console.WriteLine();
            }
            else
            {
                for (int i = 0; i < list.Count; i++)
                {
                    if (list[i] % 2 == 0)
                    {
                        Console.Write(list[i]+" ");
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
