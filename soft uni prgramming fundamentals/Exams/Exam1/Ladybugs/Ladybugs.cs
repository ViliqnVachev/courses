using System;
using System.Linq;

namespace Ladybugs
{
    class Ladybugs
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            long[] field = new long[n];
            long[] ladyBugsPosition = Console.ReadLine().Split().Select(long.Parse).Where(p => p >= 0 && p < n).ToArray();

            for (long i = 0; i < ladyBugsPosition.Length; i++)
            {
                long temp = ladyBugsPosition[i];

                field[temp] = 1;


            }

            string[] comands = Console.ReadLine().Split().ToArray();





            while (comands[0] != "end")
            {
                long index = long.Parse(comands[0]);
                string direction = comands[1];
                long fly = long.Parse(comands[2]);


                if (index < 0 || index > field.Length - 1)
                {
                    comands = Console.ReadLine().Split().ToArray();
                    continue;
                }

                if (field[index] == 0)
                {
                    comands = Console.ReadLine().Split().ToArray();
                    continue;
                }


                if (direction == "right")
                {
                    field[index] = 0;
                    long nextIndex = index;
                    while (true)
                    {
                        nextIndex += fly;
                        if (nextIndex < 0 || nextIndex >= n)
                        {
                            break;
                        }

                        if (field[nextIndex] == 1)
                        {
                            continue;
                        }
                        field[nextIndex] = 1;
                        break;
                    }
                }
                else if (direction == "left")
                {

                    field[index] = 0;
                    long nextIndex = index;
                    while (true)
                    {
                        nextIndex -= fly;
                        if (nextIndex < 0 || nextIndex >= n)
                        {
                            break;
                        }

                        if (field[nextIndex] == 1)
                        {
                            continue;
                        }
                        field[nextIndex] = 1;
                        break;
                    }
                }
            

                comands = Console.ReadLine().Split().ToArray();
            }

            Console.WriteLine(string.Join(" ", field));


        }

    }
}

