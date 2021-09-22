using System;
using System.Collections.Generic;
using System.Linq;

namespace SoftUniKaraoke
{
    class SoftUniKaraoke
    {
        static void Main(string[] args)
        {
            string[] participants = Console.ReadLine().Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            for (int i = 0; i < participants.Length; i++)
            {
                participants[i] = participants[i].Trim();
            }
            string[] songsLis = Console.ReadLine().Split(new char[] { ','}, StringSplitOptions.RemoveEmptyEntries).ToArray();
            for (int i = 0; i < songsLis.Length; i++)
            {
                songsLis[i] = songsLis[i].Trim();
            }
            string[] input = Console.ReadLine().Split(new char[] { ','}, StringSplitOptions.RemoveEmptyEntries).ToArray();
            Dictionary<string, Dictionary<string, int>> output = new Dictionary<string, Dictionary<string, int>>();
            bool isEmpty = true;

            while (input[0] != "dawn")
            {
                string participan = input[0].Trim();
                string song = input[1].Trim();
                string awards = input[2].Trim();

                if (participants.Contains(participan)&&songsLis.Contains(song))
                {
                    if (output.ContainsKey(participan) == false)
                    {
                        var help = new Dictionary<string, int>();
                        help.Add(awards, 1);
                        output.Add(participan, help);
                        isEmpty = false;
                    }
                    else
                    {
                        if (output[participan].ContainsKey(awards)==false)
                        {
                            output[participan].Add(awards, 1);
                            isEmpty = false;
                        }
                        else
                        {
                            output[participan][awards] = 1;
                            isEmpty = false;
                        }
                    }
                }
                input = Console.ReadLine().Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
            }

            if (!isEmpty)
            {
                            foreach (var item in output.OrderByDescending(x=>x.Value.Values.Sum()))
            {
                Console.WriteLine($"{item.Key}: {item.Value.Values.Sum()} awards");
                foreach (var aw in item.Value.OrderBy(k=>k.Key))
                {
                    Console.WriteLine($"--{aw.Key}");
                }
            }
            }
            else
            {
                Console.WriteLine("No awards");
            }
        }
    }
}
