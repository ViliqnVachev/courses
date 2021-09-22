using System;
using System.Collections.Generic;
using System.Linq;

namespace FixEmails
{
    class FixEmails
    {
        static void Main(string[] args)
        {
            Dictionary<string, string> emails = new Dictionary<string, string>();
            string comands = Console.ReadLine();
            string user;
            string mail;

            while (comands != "stop")
            {
                user = comands;
                mail = Console.ReadLine();
                if (emails.ContainsKey(user)==false)
                {
                    emails.Add(user, mail);

                }
                else
                {
                    emails[user] = mail;
                }
                comands = Console.ReadLine();
            }

            foreach (var item in emails.Where(x=>!x.Value.Contains(".us")&&!x.Value.Contains(".uk")))
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }

                
        }
    }
}
