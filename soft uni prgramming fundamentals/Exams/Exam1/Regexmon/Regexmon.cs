using System;
using System.Text.RegularExpressions;

namespace Regexmon
{
    class Regexmon
    {
        static void Main(string[] args)
        {
            string patternDidi = @"[^a-zA-Z\-]+";
            string patternBojo = @"[a-zA-Z]+-[a-zA-Z]+";
            var regexDidi = new Regex(patternDidi);
            var regecBojo = new Regex(patternBojo);
            string inputLine = Console.ReadLine();
            bool currentPlayerFoundMatch = true;
            int counter = 1;
            while (currentPlayerFoundMatch)
            {
                if (counter % 2 != 0)   
                {
                    var match = regexDidi.Match(inputLine);
                    if (!match.Success)
                    {
                        currentPlayerFoundMatch = false;
                        continue;
                    }
                    string currentMatchFound = match.Groups[0].Value;
                    Console.WriteLine(currentMatchFound);

                    if (match.Index > 0)
                    {
                        inputLine = inputLine.Remove(0, match.Index);
                    }
                    inputLine = inputLine.Remove(0, currentMatchFound.Length);
                }
                else     
                {
                    var match = regecBojo.Match(inputLine);
                    if (!match.Success)
                    {
                        currentPlayerFoundMatch = false;
                        continue;
                    }
                    string currentMatchFound = match.Groups[0].Value;
                    Console.WriteLine(currentMatchFound);

                    if (match.Index > 0)
                    {
                        inputLine = inputLine.Remove(0, match.Index);
                    }

                    inputLine = inputLine.Remove(0, currentMatchFound.Length);
                }
                counter++;
            }
        }
    }
}
