using System;
using System.Collections.Generic;
using System.Linq;

namespace PizzaIngredients
{
    class PizzaIngredients
    {
        static void Main(string[] args)
        {
            string[] ingredients = Console.ReadLine().Split().ToArray();
            List<string> ingredientsPizza = new List<string>() ;
            int length = int.Parse(Console.ReadLine());
            int count = 0;


            for (int i = 0; i < ingredients.Length; i++)
            {               
                if (ingredients[i].Length == length)
                {
                    ingredientsPizza.Add(ingredients[i]);
                    count++;
                    Console.WriteLine($"Adding {ingredients[i]}.");
                }
                if (count >= 10)
                {
                    break;
                }
            }
            Console.WriteLine($"Made pizza with total of {count} ingredients.");
            Console.WriteLine("The ingredients are: "+string.Join(", ",ingredientsPizza)+". ");

        }
    }
}
