using System;
using System.Collections.Generic;
using System.Linq;

namespace SumReversedNumbers
{
    class SumReversedNumbers
    {
        static void Main(string[] args)
        {
            List<string> number = Console.ReadLine().Split().ToList();
            long sum = 0;

            for (int i = 0; i < number.Count; i++)
            {
                char[] num = number[i].ToCharArray();
                num=num.Reverse().ToArray();
                string temp = "";
                for (int j = 0; j < num.Length; j++)
                {
                    temp += num[j];
                }
                sum += int.Parse(temp);
            }
            Console.WriteLine(sum);
        }
    }
}
