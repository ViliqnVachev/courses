using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _003Problem
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());


            string keyPatern = @"[s,t,a,r,S,T,A,R]";
            string planetPatern = @"(@[A-Za-z]+)(\w*):([0-9]+)!([A,D{1}])!->([0-9]+)";

            List<string> atackPlanet = new List<string>();
            List<string> destoryedPlanet = new List<string>();

            for (int i = 0; i < n; i++)
            {
                string massage = Console.ReadLine();

                var match = Regex.Matches(massage, keyPatern);

                int countKey = match.Count;

                char[] charMasage = massage.ToCharArray();
                string decriptedMasage = "";
                for (int j = 0; j < charMasage.Length; j++)
                {
                    int number = 0;
                    number = charMasage[j];
                    number = number - countKey;
                    charMasage[j] = (char)number;
                    decriptedMasage += charMasage[j];
                }


                var match2 = Regex.Match(decriptedMasage, planetPatern);
                if (Regex.IsMatch(decriptedMasage, planetPatern))
                {


                    string planetName = match2.Groups[1].Value;
                    planetName = planetName.Substring(1);

                    string atackType = match2.Groups[4].Value;

                    if (atackType == "A")
                    {
                        atackPlanet.Add(planetName);
                    }
                    else if (atackType == "D")
                    {
                        destoryedPlanet.Add(planetName);
                    }
                }
            }

            Console.WriteLine($"Attacked planets: {atackPlanet.Count}");
            atackPlanet = atackPlanet.OrderBy(x => x).ToList();

            for (int i = 0; i < atackPlanet.Count; i++)
            {
                Console.WriteLine($"-> {atackPlanet[i]}");
            }

            Console.WriteLine($"Destroyed planets: {destoryedPlanet.Count}");

            destoryedPlanet = destoryedPlanet.OrderBy(x => x).ToList();

            for (int i = 0; i < destoryedPlanet.Count; i++)
            {
                Console.WriteLine($"-> {destoryedPlanet[i]}");

            }

        }
    }
}
