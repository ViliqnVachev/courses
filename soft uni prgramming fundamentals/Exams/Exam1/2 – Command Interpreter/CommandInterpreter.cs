using System;
using System.Collections.Generic;
using System.Linq;

namespace _2___Command_Interpreter
{
    class CommandInterpreter
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();



            while (true)
            {
                string line = Console.ReadLine();
                if (line == "end")
                {
                    break;
                }

                string[] comands = line.Split().ToArray();

                if (comands[0] == "reverse")
                {
                    int start = int.Parse(comands[2]);
                    int count = int.Parse(comands[4]);
                    input = Revers(input, start, count);
                }
                else if (comands[0] == "sort")
                {
                    int start = int.Parse(comands[2]);
                    int count = int.Parse(comands[4]);
                    input = Sort(input, start, count);
                }
                else if(comands[0]== "rollLeft")
                {
                    int count = int.Parse(comands[1]);
                    input = RollLeft(input, count); 
                }
                else
                {
                    int count = int.Parse(comands[1]);
                    input = RollRight(input, count);
                }
            }

            Console.WriteLine($"[{string.Join(", ",input)}]");

        }


        static string[] RollRight(string[] input, int count)
        {
            count = count % input.Length;
            if (count < 0)
            {
                Console.WriteLine("Invalid input parameters.");
                return input;
            }

            string[] firstpart = input.Skip(input.Length-count).ToArray();
            string[] secondPart = input.Take(input.Length - count).ToArray();
            return input = firstpart.Concat(secondPart).ToArray();
        }

        static string[] RollLeft(string [] input, int count)
        {
            count = count % input.Length;
            if (count < 0)
            {
                Console.WriteLine("Invalid input parameters.");
                return input;
            }

            string[] firstpart = input.Take(count).ToArray();
            string[] secondPart = input.Skip(count).ToArray();
            return input = secondPart.Concat(firstpart).ToArray();
        }




        static string[] Sort(string[] input, int start, int count)
        {
            if (start < 0 || start >= input.Length)
            {
                Console.WriteLine("Invalid input parameters.");
                return input;
            }
            if (start + count < 0 || count < 0 || start + count - 1 >= input.Length)
            {
                Console.WriteLine("Invalid input parameters.");
                return input;
            }

            string[] firstPart = input.Take(start).ToArray();
            string[] middlePart = input.Skip(start).Take(count).OrderBy(x => x).ToArray();
            string[] LasttPart = input.Skip(start + count).ToArray();

            return input = firstPart.Concat(middlePart).Concat(LasttPart).ToArray();

        }

        static string[] Revers(string[] input, int start, int count)
        {
            if (start < 0 || start >= input.Length)
            {
                Console.WriteLine("Invalid input parameters.");
                return input;
            }
            if (start + count < 0 || count < 0 || start + count-1 >= input.Length)
            {
                Console.WriteLine("Invalid input parameters.");
                return input;
            }

            //0 1 2 3 4 5 6 7 

            string[] firstPart = input.Take(start).ToArray();
            string[] middlePart = input.Skip(start).Take(count).Reverse().ToArray();
            string[] LasttPart = input.Skip(start + count).ToArray();

            return input = firstPart.Concat(middlePart).Concat(LasttPart).ToArray();
        }
    }
}

