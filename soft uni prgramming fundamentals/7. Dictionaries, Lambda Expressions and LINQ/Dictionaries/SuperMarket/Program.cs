using System;
using System.Collections.Generic;
using System.Linq;

namespace SuperMarket
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();
            Dictionary<string, List<double>> allprod = new Dictionary<string, List<double>>();

            while (input[0]!= "stocked")
            {
                string product = input[0];
                double price = double.Parse(input[1]);
                double quant = double.Parse(input[2]);
                
                if (allprod.ContainsKey(product) == false)
                {
                    List<double> temp = new List<double>();
                    temp.Add( price);
                    temp.Add(quant);
                    allprod.Add(product, temp);
                }
                else
                {
                    allprod[product][0] = price;
                    allprod[product][1] += quant;

                }
                input = Console.ReadLine().Split().ToArray();
            }
            double total =0;
            foreach (var item in allprod)
            {
                Console.WriteLine($"{item.Key}: ${item.Value[0]:f2} * {item.Value[1]} = ${item.Value[0] * item.Value[1]:f2}");
                total += item.Value[0] * item.Value[1];
                
            }
            Console.WriteLine("------------------------------") ;
            Console.WriteLine($"Grand Total: ${total:f2}");
           
        }
    }
}
