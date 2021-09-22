using System;
using System.Linq;

namespace _002Problem
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] Bestdata = new int[n];




            int DNABestSum = 0;
            int DNABestLenght = 0;
            int momentIndex = 0;
            int momentCount = 1;
            int bCount = 0;
            while (true)
            {
                string line = Console.ReadLine();
                if (line == "Clone them!")
                {
                    break;
                }

                int[] data = line.Split(new char[] { '!' },StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

                if (n < data.Length)
                {
                    line = Console.ReadLine();
                    continue;
                }

                int sum = 0;
                int nextPosition = 0;
                int startPosition = 0;
                int lenght = 1;
                int bestPosition = 0;
                int bestLenght = 1;

                for (int i = 0; i < data.Length; i++)
                {
                    if (nextPosition >= data.Length - 1)
                    {
                        break;
                    }
                    else
                    {
                        nextPosition = i + 1;
                    }
                    if (data[i] == data[nextPosition] && data[i]==1)
                    {
                        
                        lenght++;

                        if (bestLenght < lenght)
                        {
                            bestPosition = startPosition;
                            bestLenght = lenght;
                        }
                       
                    }
                    else
                    {
                        startPosition = nextPosition;
                        lenght = 1;
                    }

                }


                sum = data.Sum();

                if (DNABestLenght < bestLenght)
                {
                    DNABestLenght = bestLenght;
                    DNABestSum = sum;
                    momentIndex = bestPosition;
                    bCount = momentCount;
                    Bestdata = data;
                }

                else if (DNABestLenght == bestLenght)
                {
                    if (momentIndex > bestPosition)
                    {
                        DNABestLenght = bestLenght;
                        DNABestSum = sum;
                        momentIndex = bestPosition;
                        bCount = momentCount;
                        Bestdata = data;
                    }
                    else if (momentIndex == bestPosition)
                    {
                         if (DNABestSum < sum)
                        {
                            DNABestLenght = bestLenght;
                            DNABestSum = sum;
                            momentIndex = bestPosition;
                            bCount = momentCount;
                            Bestdata = data;
                        }
                    }
                   
                }
                momentCount++;

            }

          
         


            Console.WriteLine($"Best DNA sample {bCount} with sum: {Bestdata.Sum()}.");
            Console.WriteLine(string.Join(" ", Bestdata));
        }
    }
}
