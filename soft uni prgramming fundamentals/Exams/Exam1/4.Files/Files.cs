using System;
using System.Collections.Generic;

namespace _4.Files
{
    class Files
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Dictionary<string, List<string>> output = new Dictionary<string, List<string>>();

            for (int i = 0; i < n; i++)
            {
                string[] line = Console.ReadLine().Split(new char[] { '\\', ';' });
                string root = line[0];
                string fileName = line[line.Length - 2];
                int size = int.Parse(line[line.Length - 1]);

                string fileinfo = $"{fileName} - {size}";

                if (output.ContainsKey(root) == false)
                {

                }

            }
        }
    }
}
