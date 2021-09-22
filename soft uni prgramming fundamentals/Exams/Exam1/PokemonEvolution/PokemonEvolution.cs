using System;
using System.Collections.Generic;
using System.Linq;

namespace PokemonEvolution
{
    class PokemonEvolution
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(new char[] { ' ', '-', '>' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            Dictionary<string, List<string>> pokemons = new Dictionary<string, List<string>>();

            while(input[0]!= "wubbalubbadubdub")
            {
                if (input.Length == 1)
                {
                    string name = input[0];
                    if (pokemons.ContainsKey(name))
                    {
                        foreach (var item in pokemons)
                        {
                            Console.WriteLine($"# {item.Key}");

                            foreach (var evol in item.Value)
                            {
                                Console.WriteLine($"{evol}");
                                
                            }
                        }
                    }


                }
                else
                {
                    string name = input[0];
                    string evolutionType = input[1];
                    string index = input[2];

                    if (pokemons.ContainsKey(name) == false)
                    {
                        pokemons[name] = new List<string>();
                    string pointsEvolutionType = evolutionType + " <-> " + index;

                    pokemons[name].Add(pointsEvolutionType);
                    }
                
                    else
                    {

                        string pointsEvolutionType = evolutionType + " <-> " + index;
                        pokemons[name].Add(pointsEvolutionType);

                    }

                   

                }

                input = Console.ReadLine().Split(new char[] { ' ', '-', '>' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            }


            foreach (var item in pokemons)
            {
                Console.WriteLine($"# {item.Key}");
                List<string> output = item.Value.ToList();
                output.OrderBy(x=>x);

                foreach (var TypeandNumber in item.Value.OrderByDescending(x => int.Parse(x.Split(new[] { " <-> " }, StringSplitOptions.None).Skip(1).First())))
                {
                    Console.WriteLine(TypeandNumber);
                }               

            }
        }
    }
}
