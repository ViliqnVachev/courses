using System;
using System.Linq;

namespace FoldAndSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int k = input.Length / 4 ;
            int[] leftNumbers = input.Take(k).Reverse().ToArray();
            int[] rightNumbers = input.Skip(3 * k).Take(k).Reverse().ToArray();            
            int[] sum = leftNumbers.Concat(rightNumbers).ToArray();
            input = input.Skip(k).Take(2 * k).ToArray();
            

            for (int i = 0; i <sum.Length; i++)
            {
                sum[i] = sum[i] + input[i];
            }

            Console.WriteLine(string.Join(" ",sum));
        }
    }
}
