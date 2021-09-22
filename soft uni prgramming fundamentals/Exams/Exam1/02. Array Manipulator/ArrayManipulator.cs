using System;
using System.Collections.Generic;
using System.Linq;

namespace _02._Array_Manipulator
{
    class ArrayManipulator
    {
        static void Main(string[] args)
        {
            int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();

            string line = Console.ReadLine();

            while (true)
            {
                if (line == "end")
                {
                    break;
                }

                string[] comand = line.Split();

                switch (comand[0])
                {

                    case "exchange":
                        int index = int.Parse(comand[1]);

                        if (index < 0 || index >= input.Length)
                        {
                            Console.WriteLine("Invalid index");
                            line = Console.ReadLine();
                            continue;
                        }
                        input = Exchange(input, index);
                        break;


                    case "max":
                        string type = comand[1];
                        int maxIndex = Max(input, type);
                        if (maxIndex == -1)
                        {
                            Console.WriteLine("No matches");
                        }
                        else
                        {
                            Console.WriteLine(maxIndex);
                        }

                        break;

                    case "min":
                        type = comand[1];
                        int minIndex = Min(input, type);
                        if (minIndex == -1)
                        {
                            Console.WriteLine("No matches");
                        }
                        else
                        {
                            Console.WriteLine(minIndex);
                        }
                        break;

                    case "first":
                        type = comand[2];
                        int count = int.Parse(comand[1]);
                        List<int> first = First(input, type);
                        if (count-1 >= input.Length)
                        {
                            Console.WriteLine("Invalid count");
                        }
                        else if (first.Count== 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else if (count > first.Count)
                        {
                            Console.WriteLine($"[{string.Join(", ", first)}]");
                        }
                        else
                        {
                            List<int> helper = first.Take(count).ToList();
                            Console.WriteLine($"[{string.Join(", ", helper)}]");
                        }
                        break;

                    case "last":
                        type = comand[2];
                         count = int.Parse(comand[1]);
                        List<int> last = Last(input, type);
                        if (count-1 >= input.Length)
                        {
                            Console.WriteLine("Invalid count");
                        }
                        else if (last.Count==0)
                        {
                            Console.WriteLine("[]");
                        }
                        else if (count > last.Count)
                        {
                            Console.WriteLine($"[{string.Join(", ", last)}]");
                        }

                        else
                        {
                            List<int> helper = last.Skip(count).ToList();
                            Console.WriteLine($"[{string.Join(", ", helper)}]");
                        }
                        break;
                }



                line = Console.ReadLine();
            }

            Console.WriteLine("["+string.Join(", ",input)+"]");
        }

        static List<int> Last(int[] input, string type)
        {
            List<int> firstOdd = new List<int>();
            List<int> firstEven = new List<int>();


            for (int i = 0; i < input.Length; i++)
            {
                if (input[i] % 2 != 0)
                {
                    firstOdd.Add(input[i]);
                }
                else
                {
                    firstEven.Add(input[i]);
                }
            }
            if (type == "odd")
            {
                return firstOdd;
            }
            return firstEven;

        }

        static List<int> First(int[] input, string type)
        {
            List<int> firstOdd = new List<int>();
            List<int> firstEven = new List<int>();


            for (int i = 0; i < input.Length; i++)
            {
                if (input[i] % 2 != 0)
                {
                    firstOdd.Add(input[i]);
                }
                else
                {
                    firstEven.Add(input[i]);
                }
            }
            if (type == "odd")
            {
                return firstOdd;
            }
            return firstEven;

        }



        static int Min(int[] input, string type)
        {
            int maxIndex = -1;
            int number = int.MaxValue;
            if (type == "odd")
            {
                //todo
                for (int i = 0; i < input.Length; i++)
                {
                    if (input[i] % 2 != 0)
                    {
                        if (i >= maxIndex && input[i] <= number)
                        {
                            maxIndex = i;
                            number = input[i];
                        }
                    }
                }

            }
            else
            {
                //todo

                for (int i = 0; i < input.Length; i++)
                {
                    if (input[i] % 2 == 0)
                    {
                        if (i >= maxIndex && input[i] <= number)
                        {
                            maxIndex = i;
                            number = input[i];
                        }
                    }
                }
            }
            return maxIndex;

        }



        static int Max(int[] input, string type)
        {
            int maxIndex = -1;
            int number = int.MinValue;
            if (type == "odd")
            {
                //todo
                for (int i = 0; i < input.Length; i++)
                {
                    if (input[i] % 2 != 0)
                    {
                        if (i >= maxIndex && input[i] >= number)
                        {
                            maxIndex = i;
                            number = input[i];
                        }
                    }
                }

            }
            else
            {
                //todo

                for (int i = 0; i < input.Length; i++)
                {
                    if (input[i] % 2 == 0)
                    {
                        if (i >= maxIndex && input[i] >= number)
                        {
                            maxIndex = i;
                            number = input[i];
                        }
                    }
                }
            }
            return maxIndex;
        }

        static int[] Exchange(int[] input, int index)
        {

            List<int> firstpart = new List<int>();
           List<int> secondpart = new List<int>();

            for (int i = index+1; i <= input.Length; i++)
            {
                firstpart.Add(input[i]);
            
            }

            for (int i = 0; i <= index; i++)
            {
                secondpart.Add(input[i]);
            }

            return input = firstpart.Concat(secondpart).ToArray();

            

           
        }
    }
}
