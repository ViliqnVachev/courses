using System;
using System.Collections.Generic;
using System.Linq;

namespace AnonymousThreat
{
    class AnonymousThreat
    {
        static void Main(string[] args)
        {
            List<string> input = Console.ReadLine().Split().ToList();
            string [] comands= Console.ReadLine().Split().ToArray();
            while (comands[0] != "3:1")
            {
                string operation = comands[0];
                int startIndex=0;
                int endIndex=0;
                int index=0;
                int partition = 0;
               if(operation== "merge")
                {
                    startIndex = int.Parse(comands[1]);
                    endIndex = int.Parse(comands[2]);
                    input = Merge(input, startIndex, endIndex);
                }
                else
                {
                    index = int.Parse(comands[1]);
                    partition = int.Parse(comands[2]);
                    input = Divide(input, index, partition);

                }
                comands = Console.ReadLine().Split().ToArray();
            }
            Console.WriteLine(string.Join(" ",input));
        }

        static List<string> Divide(List<string> input,int index,int partition)
        {
            if (index < 0 || index >= input.Count)
            {
                index = 0;
            }
            if (index >= input.Count || index < 0)
            {
                index = input.Count - 1;
            }

            List<string> divide = new List<string>();
            string temp = input[index];
            if (temp.Length%partition == 0)
            {
                int leters =  temp.Length/partition;
                
                int skip = 0;
                for (int i = 0; i < partition; i++)
                {
                   char []  help = temp.Skip(skip).Take(leters).ToArray();
                    string h = "";
                    for (int j = 0; j < help.Length; j++)
                    {
                        h += help[j];
                    }
                   
                    skip += leters;
                    divide.Add(h);
                }
                input.RemoveAt(index);
                input.InsertRange(index, divide);
            }
            else
            {
                int leters = temp.Length/partition;
               
                int skip = 0;
                for (int i = 0; i < partition;  i++)
                {
                    if (i == partition-1)
                    {
                        char[] help = temp.Skip(skip).Take(leters+1).ToArray();
                        string h = "";
                        for (int j = 0; j < help.Length; j++)
                        {
                            h += help[j];
                        }
                        skip += leters;
                        divide.Add(h);
                    }
                    else
                    {
                        char[] help = temp.Skip(skip).Take(leters).ToArray();
                        string h = "";
                        for (int j = 0; j < help.Length; j++)
                        {
                            h += help[j];
                        }
                        skip += leters;
                        divide.Add(h);
                    }
                    
                }
                input.RemoveAt(index);
                input.InsertRange(index, divide);
            }
                return input;
        }


        static List<string> Merge(List<string>input,int startIndex,int endIndex)
        {
            List<string> merge = input;
            if (startIndex < 0 || startIndex>=input.Count)
            {
                startIndex = 0;
            }
            if (endIndex >= input.Count|| endIndex<0)
            {
                endIndex = input.Count - 1;
            }
            string temp = "";
            for (int i = startIndex; i <= endIndex; i++)
            {
                temp += input[i];
            }
            merge.RemoveRange(startIndex, endIndex - startIndex+1);
            merge.Insert(startIndex,temp);
            return merge;
        }
    }
}
