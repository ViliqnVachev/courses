using System;
using System.Globalization;
using System.Linq;
using System.Numerics;

namespace SinoTheWalker
{
    class SinoTheWalker
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            DateTime dt = DateTime.ParseExact(input, "H:mm:ss", CultureInfo.InvariantCulture);


            int steps = int.Parse(Console.ReadLine()) % 86400;
            int secondsPerSteps = int.Parse(Console.ReadLine()) % 86400;
            double sumStepsSeconds = steps * secondsPerSteps;
            TimeSpan time = TimeSpan.FromSeconds(sumStepsSeconds);
            string temp = time.ToString(@"hh\:mm\:ss");
            DateTime end = DateTime.ParseExact(temp, "H:mm:ss", CultureInfo.InvariantCulture);

            end = dt.Add(end.TimeOfDay);

            Console.WriteLine($"Time Arrival: {end.TimeOfDay}");







            // int[] timeLeft = Console.ReadLine().Split(':').Select(int.Parse).ToArray();
            // int hours = timeLeft[0];
            // int minutes = timeLeft[1];
            // int seconds = timeLeft[2];

            // int steps = int.Parse(Console.ReadLine());
            // int secondsPerSteps = int.Parse(Console.ReadLine());
            //// BigInteger sum = steps * secondsPerSteps;
            //// seconds = seconds + sum;
            // double sumStepsSeconds = steps * seconds;
            // TimeSpan time = TimeSpan.FromSeconds(sumStepsSeconds);
            // string temp = time.ToString(@"hh\:mm\:ss");
            // int[] m = temp.Split(':').Select(int.Parse).ToArray();

            // int temphours = m[0];
            // int tempminutes = m[1];
            // int tempseconds = m[2];

            // //while (seconds > 59)
            // //{
            // //    minutes++;
            // //    seconds = seconds - 60;
            // //    while (minutes > 59)
            // //    {
            // //        hours++;
            // //        minutes = minutes - 60;
            // //        while (hours > 23)
            // //        {
            // //            hours = hours - 24;                       
            // //        }
            // //    }
            // //}
            // //Console.WriteLine($"Time Arrival: {hours:d02}:{minutes:d02}:{seconds:d02}");
        }
    }
}
