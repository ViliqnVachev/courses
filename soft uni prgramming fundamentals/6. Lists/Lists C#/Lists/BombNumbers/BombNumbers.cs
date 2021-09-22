using System;
using System.Collections.Generic;
using System.Linq;

namespace BombNumbers
{
    class BombNumbers
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();
            List<int> magicNumbers = Console.ReadLine().Split().Select(int.Parse).ToList();
            int bomb = magicNumbers[0];
            int power = magicNumbers[1];
            int sum = 0;


            for (int i = 0; i < numbers.Count(); i++)
            {
                if (numbers[i]==bomb)
                {

                    for (int j = Math.Max(i - power, 0); j <= Math.Min(i + power, numbers.Count() - 1); j++)
                    {
                        int temp = 0;
                        numbers[j]= 0;
                    }

                }
            }



            foreach (var num in numbers)           
            {
                sum += num;
            }
            Console.WriteLine(sum);
        }
        }
    }

