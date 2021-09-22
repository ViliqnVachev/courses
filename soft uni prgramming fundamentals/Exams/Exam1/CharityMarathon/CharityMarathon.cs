using System;
using System.Numerics;

namespace CharityMarathon
{
    class CharityMarathon
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            long allRunners = long.Parse(Console.ReadLine());
            int lapsPerDay = int.Parse(Console.ReadLine());
            int lapLenght = int.Parse(Console.ReadLine());
            int runersPerDay= int.Parse(Console.ReadLine());
            decimal money = decimal.Parse(Console.ReadLine());

            long capaciyForAll = runersPerDay * days;
            if (allRunners > capaciyForAll)
            {
                allRunners = capaciyForAll;
            }
            long totalMeters = allRunners * lapLenght * lapsPerDay;
            long totalKm = totalMeters / 1000;
            decimal moneyForTheMarathon = money * totalKm;

            Console.WriteLine($"Money raised: {moneyForTheMarathon:F2}");
        }
    }
}
