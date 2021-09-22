using System;
using System.Linq;

namespace JumpAround
{
    class JumpAround
    {
        static void Main(string[] args)
        {
            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int i = 0;
            int sum =0;
            int a = numbers.Length - 1;
            bool isPosible = true;
            while (isPosible == true)
            {
                sum += numbers[i];
                if (i <= a)
                {
                   if( i + numbers[i] > numbers.Length)
                    {
                        if (i - numbers[i] < 0)
                        {
                            isPosible = false;
                        }
                        else
                        {
                            i = i - numbers[i];                           
                        }
                    }
                    else
                    {
                    i=i+numbers[i];
                  
                    }
                }      
            }
            Console.WriteLine(sum);
        }
    }
}
