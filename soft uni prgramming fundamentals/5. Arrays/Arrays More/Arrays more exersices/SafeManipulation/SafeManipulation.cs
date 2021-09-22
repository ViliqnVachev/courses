using System;
using System.Linq;

namespace SafeManipulation
{
    class SafeManipulation
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine().Split().ToArray();
            string [] comands = Console.ReadLine().Split().ToArray();

            while (comands[0] != "END")
            {
                if (comands[0] == "Distinct")
                {
                    words = words.Distinct().ToArray();
                } else if (comands[0] == "Reverse")
                {
                    words = words.Reverse().ToArray();
                }
                else if (comands[0] == "Replace")
                {
                    int index = int.Parse(comands[1]);
                    string value = comands[2];
                    if (index >= words.Length || index < 0)
                    {
                        Console.WriteLine("Invalid input!");
                    }
                    else
                    {
                        words[index] = value;
                    }
                }
                else
                {
                    Console.WriteLine("Invalid input!");
                }
                comands = Console.ReadLine().Split().ToArray();
            }

            Console.WriteLine(string.Join(", ",words));
        }
    }
}
