using System;

namespace _001Problem
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal ivanchosMoney = decimal.Parse(Console.ReadLine());
            int numberOfStudents = int.Parse(Console.ReadLine());
            int more = (int)Math.Ceiling(numberOfStudents * 0.1);
            decimal priceOfLightsabers = decimal.Parse(Console.ReadLine());
            decimal priceOFRobes = decimal.Parse(Console.ReadLine());
            decimal priceOFBelts = decimal.Parse(Console.ReadLine());
            int freeBelt = numberOfStudents / 6;


            decimal sum = (priceOfLightsabers * (numberOfStudents + more)) + (priceOFRobes * numberOfStudents) + (priceOFBelts * (numberOfStudents-freeBelt));

            if (ivanchosMoney >= sum)
            {
                Console.WriteLine($"The money is enough - it would cost {sum:F2}lv.");
            }
            else
            {
                decimal need = sum - ivanchosMoney;
                Console.WriteLine($"Ivan Cho will need {need:F2}lv more.");
            }

        }
    }
}
