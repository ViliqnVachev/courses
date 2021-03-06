using System;
using System.Collections.Generic;
using System.Linq;

namespace tset
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] comands = Console.ReadLine().Split().ToArray();

            Dictionary<string, Dictionary<string, int>> userInfo = new Dictionary<string, Dictionary<string, int>>();
           
            while (comands[0] != "end")
            {
                string[] IP = comands[0].Split('=').ToArray();
                string[] user = comands[2].Split('=').ToArray();

                if (userInfo.ContainsKey(user[1]) == false)
                {
                    Dictionary<string, int> temp = new Dictionary<string, int>();

                    if (temp.ContainsKey(IP[1]) == false)
                    {
                        temp.Add(IP[1], 1);
                    }
                   
                    userInfo.Add(user[1], temp);
                }
                else
                {
                    
                    if (userInfo[user[1]].ContainsKey(IP[1]) == false)
                    {
                        userInfo[user[1]].Add(IP[1], 1);
                    }
                    else
                    {
                        userInfo[user[1]][IP[1]]++;
                    }
                    userInfo[user[1]]= userInfo[user[1]];
                }
                comands = Console.ReadLine().Split().ToArray();
            }

            foreach (var user in userInfo.OrderBy(x=>x.Key))
            {
                Console.WriteLine($"{user.Key}: ");
                    List<string> helpList = new List<string>();
                foreach (var item in user.Value)
                {
                    string help = $"{item.Key} => {item.Value}";
                    helpList.Add(help);
                }
                    Console.WriteLine(string.Join(", ",helpList)+".");
            }
            {

            }
        }
    }
}
