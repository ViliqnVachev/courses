using System;
using System.Linq;

namespace GrabAndGo
{
    class GrabAndGo
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int num = int.Parse(Console.ReadLine());

            int position=-1;

            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] == num)
                {
                    position = i;
                }
            }

            if (position < 0)
            {
                Console.WriteLine("No occurrences were found!");
            }
            else
            {
                long sum = 0;
                for (int i = 0; i < position; i++)
                {
                    sum += numbers[i];
                }
                Console.WriteLine(sum);
            }
        }
    }
}
