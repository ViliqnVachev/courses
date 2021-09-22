using System;
using System.Collections.Generic;
using System.Linq;

namespace TakeSkipRope
{
    class TakeSkipRope
    {
        static void Main(string[] args)
        {
            string massage = Console.ReadLine();
            List<int>numbers=new List<int>();
            List<char>chars=new List<char>();

            for (int i = 0; i < massage.Length; i++)
            {
                if (massage[i] >= '0' && massage[i] <= '9')
                {
                    string temp = massage[i].ToString();
                    numbers.Add(int.Parse(temp));
                }
                else
                {
                    chars.Add(massage[i]);
                }
            }

            List<int> skip = new List<int>();
            List<int> take = new List<int>();

            for (int i = 0; i < numbers.Count; i++)
            {
                if (i % 2 == 0)
                {
                    take.Add(numbers[i]);
                }
                else
                {
                    skip.Add(numbers[i]);
                }
            }

            string result = "";
            int total = 0;
            for (int i = 0; i < skip.Count; i++)
            {

                int skupCont = skip[i];
                int takeCont = take[i];
                result += new string (chars.Skip(total).Take(takeCont).ToArray());
                total += skupCont + takeCont;

            }
            Console.WriteLine(result);
        }
    }
}
