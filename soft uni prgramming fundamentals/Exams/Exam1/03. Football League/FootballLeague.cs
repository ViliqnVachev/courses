using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _03._Football_League
{
    class FootballLeague
    {
        static void Main(string[] args)
        {
            string key = Console.ReadLine();
            Dictionary<string, int> goals = new Dictionary<string, int>();
            Dictionary<string, int> points = new Dictionary<string, int>();
            int win = 3;
            int loss = 0;
            int draft = 1;

            while (true)
            {
                string line = Console.ReadLine();
                if (line == "final")
                {
                    break;
                }

                string[] data = line.Split();
                string teamA = data[0];
                string teamB = data[1];

                string[] result = data[2].Split(':');
                int resultA = int.Parse(result[0]);
                int resultB = int.Parse(result[1]);

                string patern = $@"("+key+@")([A-Za-z]+)(\1)";
               

                var matchA = Regex.Match(teamA, patern);
                string firstTeam = matchA.Groups[2].Value.ToUpper();
                char[] teeamsA = firstTeam.ToCharArray();
                teeamsA=teeamsA.Reverse().ToArray();
                firstTeam = "";
                for (int i = 0; i < teeamsA.Length; i++)
                {
                    firstTeam += teeamsA[i];
                }
                if (points.ContainsKey(firstTeam) == false)
                {
                    points.Add(firstTeam, 0);
                    goals.Add(firstTeam, resultA);
                }
                else
                {

                goals[firstTeam] += resultA;
                }

                var matchB = Regex.Match(teamB, patern);
                string secondTeam = matchB.Groups[2].Value.ToUpper();
                char[] teeamsB = secondTeam.ToCharArray();
                teeamsB = teeamsB.Reverse().ToArray();
                secondTeam = "";
                for (int i = 0; i < teeamsB.Length; i++)
                {
                    secondTeam += teeamsB[i];
                }

                if (points.ContainsKey(secondTeam) == false)
                {
                    points.Add(secondTeam, 0);
                    goals.Add(secondTeam, resultB);
                }
                else
                {
                goals[secondTeam] += resultB;

                }

                if (resultA > resultB)
                {
                    points[firstTeam] += win;
                    points[secondTeam] += loss;
                }
                else if (resultA < resultB)
                {
                    points[secondTeam] += win;
                    points[firstTeam] += loss;
                }
                else
                {
                    points[secondTeam] += draft;
                    points[firstTeam] += draft;
                }
                 
            }
            int count = 1;

                Console.WriteLine("League standings:");
            foreach (var item in points.OrderByDescending(x=>x.Value))
            {
                Console.WriteLine($"{count}. {item.Key} {item.Value}");
                count++;
            }

                Console.WriteLine("Top 3 scored goals:");
            foreach (var item in goals.OrderByDescending(x=>x.Value))
            {
                Console.WriteLine($"- {item.Key} -> {item.Value}");
            }
        }
    }
}
