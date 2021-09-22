using System;
using System.Collections.Generic;
using System.Linq;

namespace ByteFlip
{
    class ByteFlip
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();
            List<string> hexNumbers = new List<string>();
            for (int i = 0; i < input.Length; i++)
            {
                if (input[i].Length == 2)
                {
                    hexNumbers.Add(input[i]);
                }

            }
            List<string> dec = new List<string>();
            for (int i = 0; i < hexNumbers.Count; i++)
            {
                string temp = "";
                char[] d = hexNumbers[i].ToCharArray() ;
                for (int j= d.Length-1; j >=0; j--)
                {
                    temp += d[j];
                }
                dec.Add(temp);
            }

            dec.Reverse();
            foreach (var item in dec)
            {
                int decValue=  int.Parse(item, System.Globalization.NumberStyles.HexNumber);
                Console.Write((char)decValue);
            }
            Console.WriteLine();

        }
    }
}
