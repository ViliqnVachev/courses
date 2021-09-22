using System;

namespace PokeMon
{
    class PokeMon
    {
        static void Main(string[] args)
        {
            long n = long.Parse(Console.ReadLine());
            long m = long.Parse(Console.ReadLine());
            long y = long.Parse(Console.ReadLine());
            long count = 0;
            long firstN = n;

            while (n >= m)
            {
                if (n - m < n)
                {
                    n = n - m;
                    count++; 
                }
                decimal result = firstN * 0.5M;
                if (n == result && y>0 )
                {
                    n = n / y;
                }
            }
            Console.WriteLine(n);
            Console.WriteLine(count);
        }
    }
}
