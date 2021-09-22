using System;
using System.Collections.Generic;
using System.Linq;

namespace AnonymousCache
{
    class AnonymousCache
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(new char[] { ' ', '-', '>', '|' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            Dictionary<string, Dictionary<string, long>> set = new Dictionary<string, Dictionary<string, long>>();
            Dictionary<string, Dictionary<string, long>> cache = new Dictionary<string, Dictionary<string, long>>();


            while (input[0]!= "thetinggoesskrra")
            {
                string dataSet = "";
                string dataKey = "";
                long dataSize = 0;
                if (input.Length == 1)
                {
                    dataSet = input[0];
                    if (set.ContainsKey(dataSet) == false)
                    {                       
                        // da preoverq cache
                        if (set.ContainsKey(dataSet) == false)
                        {
                            set.Add(dataSet, new Dictionary<string, long>());
                            if (cache.ContainsKey(dataSet))
                            {
                                set[dataSet] = cache[dataSet];
                            }
                        }
                    }
                }
                else
                {
                    dataKey = input[0];
                    dataSize = long.Parse(input[1]);
                    dataSet = input[2];

                    if (set.ContainsKey(dataSet)==false)
                    {
                        if (cache.ContainsKey(dataSet) == false)
                        {
                            Dictionary<string, long> helpCache = new Dictionary<string, long>();
                            helpCache.Add(dataKey, dataSize);
                            cache.Add(dataSet, helpCache);
                        }
                        else
                        {
                            cache[dataSet].Add(dataKey, dataSize);
                        }
                    }
                    else
                    {
                        set[dataSet].Add(dataKey, dataSize);
                    }
                }

                input = Console.ReadLine().Split(new char[] { ' ', '-', '>', '|' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            }
            List<string> listSet = new List<string>();
            List<string> listKey = new List<string>();

            foreach (var item in set.OrderByDescending(x=>x.Value.Values.Sum()))
            {
                string temp=($"Data Set: {item.Key}, Total Size: {item.Value.Values.Sum()}");
              // Console.WriteLine($"Data Set: {item.Key}, Total Size: {item.Value.Values.Sum()}");
               listSet.Add(temp);
                foreach (var us in item.Value)
                {
                    string tempKey=($"$.{us.Key}");
                    //Console.WriteLine($"$.{us.Key}");
                     listKey.Add(tempKey);
                }
                break;
            }

            Console.WriteLine(string.Join("",listSet));
            for (int i = 0; i < listKey.Count; i++)
            {
                Console.WriteLine(listKey[i]);
            }
        }
    }
}
