using System;
using System.Numerics;

namespace Snowballs1

{
    class Snowballs1

    {
        static void Main(string[] args)        {


            // BgInteger Na Stepen !!!!!!!!!!!!!!!!!!!!!!!!!

            int n = int.Parse(Console.ReadLine());
            int snow = 0;
            int time = 0;
            int quality = 0;

            BigInteger bestValue = 0;
            BigInteger temp = 0;

            for (int i = 0; i < n; i++)
            {
                int snowballSnow = int.Parse(Console.ReadLine());
                int snowballTime = int.Parse(Console.ReadLine());
                int snowballQuality = int.Parse(Console.ReadLine());

                temp = BigInteger.Pow(snowballSnow / snowballTime, snowballQuality);

                if (temp > bestValue)
                {
                    bestValue = temp;
                    snow = snowballSnow;
                    time = snowballTime;
                    quality = snowballQuality;
                }
            }
            Console.WriteLine($"{snow} : {time} = {bestValue} ({quality})");
        }
    }
}
