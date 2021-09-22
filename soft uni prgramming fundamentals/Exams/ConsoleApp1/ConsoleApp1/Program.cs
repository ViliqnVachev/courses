using System;
using System.Collections.Generic;
using System.Linq;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            List<double> list = Console.ReadLine().Split(' ').Select(double.Parse).ToList();

            int index = 0;

            while (index <= list.Count) {

                if (index == list.Count - 1)
                {
                    break;
                }
                
                if (list[index] == list[index + 1])
                {
                    list[index] = list[index] + list[index + 1];
                    list.Remove(list[index + 1]);
                    index = 0;
                }
                else
                {
                    index++;
                }
            }

            Console.WriteLine(string.Join(" ",list));

        }
    }
}
