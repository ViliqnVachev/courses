using System;
using System.Linq;

namespace Arrays_more_exersices
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string [] comand = Console.ReadLine().Split().ToArray();

                if(comand[0]== "Distinct")
                {
                    input = input.Distinct().ToArray();
                }else if(comand[0]== "Reverse")
                {
                    input = input.Reverse().ToArray();
                }
                else
                {
                    int index = int.Parse(comand[1]);
                    string value = comand[2];
                    input[index] = value;
                }
            }
            Console.WriteLine(string.Join(", ",input));
        }
    }
}
