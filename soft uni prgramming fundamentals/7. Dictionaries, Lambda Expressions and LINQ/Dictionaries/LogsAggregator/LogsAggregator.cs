using System;
using System.Collections.Generic;
using System.Linq;

namespace LogsAggregator
{
    class LogsAggregator
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Dictionary<string, Dictionary<string, int>> agreg = new Dictionary<string, Dictionary<string, int>>();

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split().ToArray();
                string user = input[1];
                string ip = input[0];
                int count = int.Parse(input[2]);

                if (agreg.ContainsKey(user) == false)
                {
                    Dictionary<string, int> ipContent = new Dictionary<string, int>();
                    ipContent.Add(ip, count);
                    agreg.Add(user, ipContent);
                }
                else
                {
                    if (agreg[user].ContainsKey(ip) == false)
                    {
                        agreg[user].Add(ip, count);
                    }
                    else
                    {
                        agreg[user][ip] += count;
                    }
                }
            }
            foreach (var user in agreg.OrderBy(x=>x.Key))
            {
                Console.Write($"{user.Key}: {user.Value.Values.Sum()} ");
                List<string> helper = new List<string>();
                foreach (var item in user.Value.OrderBy(x=>x.Key))
                {
                 string temp=$"{item.Key}";
                    helper.Add(temp);
                }
                Console.WriteLine("["+string.Join(", ",helper)+"]");
            }
        }
    }
}
