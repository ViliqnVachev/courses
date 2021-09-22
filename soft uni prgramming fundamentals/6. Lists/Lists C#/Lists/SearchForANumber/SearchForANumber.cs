using System;
using System.Collections.Generic;
using System.Linq;

namespace SearchForANumber
{
    class SearchForANumber
    {
        static void Main(string[] args)
        {
            List<int> inputNumbers = Console.ReadLine().Split().Select(int.Parse).ToList();
            int[] comands = Console.ReadLine().Split().Select(int.Parse).ToArray();

            List<int> list = new List<int>();

            for (int i = 0; i < comands[0]; i++)
            {
                list.Add(inputNumbers[i]);
            }
            while (comands[1] != 0)
            {
                list.RemoveAt(0);
                comands[1]--;
            }
            bool isFint = false;

            foreach (var num in list)
            {
                if (num == comands[2])
                {
                    isFint = true;
                }
            }
            if (isFint)
            {
                Console.WriteLine("YES!");
            }
            else
            {
                Console.WriteLine("NO!");
            }














        //    list = list.Take(comands[0]).ToList();
        //   for (int i = 0; i < comands[2]; i++)
        //   {
        //    list.Remove(i);
        //   }

            //   if (list.Contains(comands[2]))
            //   {
            //       Console.WriteLine("YES!");
            //   }
            //  else
            //  {
            //   Console.WriteLine("NO!");
            // }
        }
    }
}
