using System;
using System.Collections.Generic;
using System.Linq;

namespace Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();
            int position = 0;
            int lenght = 1;
            int bestPosition = 0;
            int BestLenght = 1;

            for (int i = 0; i < numbers.Count-1; i++)
            {
                if (numbers[i] == numbers[i + 1])
                {
                    lenght++;
                    if (lenght > BestLenght)
                    {
                        bestPosition = position;
                        BestLenght = lenght;
                    }
                }
                else
                {
                    position = i + 1;
                    lenght = 1;
                }
            }
            List<int> output = new List<int>();
            for (int i = 0; i < BestLenght; i++)
            {
                output.Add(numbers[bestPosition + i]);
            }
            Console.WriteLine(string.Join(" ",output));
        }
    }
}
