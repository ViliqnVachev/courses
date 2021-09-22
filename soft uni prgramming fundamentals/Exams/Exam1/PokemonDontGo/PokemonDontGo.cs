using System;
using System.Collections.Generic;
using System.Linq;

namespace PokemonDontGo
{
    class PokemonDontGo
    {
        static void Main(string[] args)
        {
            List<int> pokemons = Console.ReadLine().Split().Select(int.Parse).ToList();
            List<int> sum = new List<int>();
            while (pokemons.Count > 0)
            {
                int index = int.Parse(Console.ReadLine());

                if (index < 0)
                {
                    int temp = pokemons[0];
                    sum.Add(temp);
                    pokemons[0] = pokemons[pokemons.Count - 1];
                    for (int i = 0; i < pokemons.Count; i++)
                    {
                        if (pokemons[i] <= temp)
                        {
                            pokemons[i] += temp;
                        }
                        else
                        {
                            pokemons[i] -= temp;
                        }
                    }
                    continue;
                }
                if (index > pokemons.Count - 1)
                {
                    int temp = pokemons[pokemons.Count - 1];
                    sum.Add(temp);
                    pokemons[pokemons.Count - 1] = pokemons[0];
                    for (int i = 0; i < pokemons.Count; i++)
                    {
                        if (pokemons[i] <= temp)
                        {
                            pokemons[i] += temp;
                        }
                        else
                        {
                            pokemons[i] -= temp;
                        }
                    }
                    continue;
                }

                int corentValue = pokemons[index];
                sum.Add(corentValue);
                pokemons.RemoveAt(index);
                for (int i = 0; i < pokemons.Count; i++)
                {
                    if (pokemons[i] <= corentValue)
                    {
                        pokemons[i] += corentValue;
                    }
                    else
                    {
                        pokemons[i] -= corentValue;
                    }
                }
            }
            int result = 0;

            foreach (var item in sum)
            {
                result += item;
            }
            Console.WriteLine(result);
        }
    }
}
