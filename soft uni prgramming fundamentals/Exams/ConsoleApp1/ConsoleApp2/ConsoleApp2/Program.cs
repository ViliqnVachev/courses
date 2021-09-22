using System;
using System.Globalization;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            string dateStart = Console.ReadLine();
             string dateEnd = Console.ReadLine();

            DateTime startDate = Convert.ToDateTime(dateStart);

            DateTime endDate = Convert.ToDateTime(dateEnd);
              
          int holidaysCount = 0;
            for (DateTime date = startDate; date <= endDate; date.AddDays(1))
            {
                if (date.DayOfWeek == DayOfWeek.Saturday && date.DayOfWeek == DayOfWeek.Sunday)
                {
                    holidaysCount++;
                }
            }
          Console.WriteLine(holidaysCount);
      }
  
        }
    
}
