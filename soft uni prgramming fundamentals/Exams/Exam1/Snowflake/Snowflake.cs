using System;
using System.Text.RegularExpressions;

namespace Snowflake
{
    class Snowflake
    {
        static void Main(string[] args)
        {
            string surfacePatern = @"^[^0-9A-Za-z]+$";
            string mantlePatern = @"^[0-9_]+$";
            string corePatern = @"^[^0-9A-Za-z]+[0-9_]+([A-Za-z]+)[0-9_]+[^0-9A-Za-z]+$";

            string core = string.Empty;
            for (int i = 1; i <= 5; i++)
            {
                string input = Console.ReadLine();
                if (i == 1 || i == 5)
                {
                    if (Regex.IsMatch(input, surfacePatern))
                    {
                        var match = Regex.Match(input, surfacePatern);
                        string temp = match.Value;
                        if (temp.Length == input.Length)
                        {
                            continue;
                        }
                    }
                }
                if (i == 2 || i == 4)
                {
                    if (Regex.IsMatch(input, mantlePatern))
                    {
                        var match = Regex.Match(input, mantlePatern);
                        string temp = match.Value;
                        if (temp.Length == input.Length)
                        {
                            continue;
                        }
                    }
                }
                if (i == 3)
                {
                    if (Regex.IsMatch(input, corePatern))
                    {
                        var match = Regex.Match(input, corePatern);
                        string temp = match.Value;
                        if (temp.Length == input.Length)
                        {
                            core = match.Groups[1].Value;
                            continue;
                        }
                    }
                }
            }
        

            if (core.Length == 0)
            {
                Console.WriteLine("Invalid");
            }
            else
            {
                
                Console.WriteLine("Valid");
                Console.WriteLine(core.Length);
            }
        }
    }
}
