using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;

namespace AnonymousDownsite1
{
    class AnonymousDownsite1
    {
        static void Main(string[] args)
        {
            int sites = int.Parse(Console.ReadLine());
            int secKey = int.Parse(Console.ReadLine());
            List<string> siteNames = new List<string>();
            decimal lost = 0;
            for (int i = 0; i < sites; i++)
            {
                string[] input = Console.ReadLine().Split().ToArray();
                siteNames.Add(input[0]);
                long siteVisit = long.Parse(input[1]);
                decimal pricePerVisit = decimal.Parse(input[2]);
                lost += siteVisit * pricePerVisit;

            }
            BigInteger securityToken = BigInteger.Pow(secKey, sites);
            for (int i = 0; i < siteNames.Count; i++)
            {
                Console.WriteLine(siteNames[i]);
            }
            
            Console.WriteLine($"Total Loss: {lost:f20}");
            Console.WriteLine($"Security Token: {securityToken}");
        }
    }
}
