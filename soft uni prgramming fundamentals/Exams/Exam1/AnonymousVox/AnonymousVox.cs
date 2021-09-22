using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace AnonymousVox
{
    class AnonymousVox
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] placeholders = Console.ReadLine().Split(new char[] { '{', '}' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            string pattern = @"([A-Za-z]+)(.+)(\1)";

            var match = Regex.Matches(input, pattern);
            int index = 0;
            for (int i = 0; i < match.Count; i++)
            {
                if (index >=placeholders.Length)
                {
                    break;
                }
                else
                {                
                string oldString = match[i].Groups[2].Value;
                string newString = placeholders[index];
                input=input.Replace(oldString, newString);
                    index++;
            }
        }
        Console.WriteLine(input);
        }
    }
}
