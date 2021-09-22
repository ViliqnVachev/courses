using System;
using System.Collections.Generic;
using System.Linq;

namespace HandsOfCards
{
    class HandsOfCards
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(":").ToArray();
            Dictionary<string, List<string>> result = new Dictionary<string, List<string>>();

            while (input[0] != "JOKER")
            {
                string playerName = input[0];
                List<string>cards = input[1].Split(new char[] { ',', ' ' },StringSplitOptions.RemoveEmptyEntries).ToList();
                cards = cards.Distinct().ToList();
                             

                if (playerName != ":")
                {
                    if (result.ContainsKey(playerName) == false)
                    {
                        result.Add(playerName, cards);
                    }
                    result[playerName].AddRange(cards);
                    result[playerName] = result[playerName].Distinct().ToList(); ;
                }
                      
                  

                input = Console.ReadLine().Split(":").ToArray();
            }

            foreach (var item in result)
            {

                int sum = 0;
                int number; ;
                int s = 4;
                int h = 3;
                int d = 2;
                int c = 1;
                foreach (var card in item.Value)
                {
                    for (int i = 0; i < 1; i++)
                    {
                        char[] num = card.ToCharArray();

                        if (num.Length == 3)
                        {
                            number = 10;
                            if (num[num.Length - 1] == 'S')
                            {
                                sum = sum + (number * s);
                            }
                            else if (num[num.Length - 1] == 'H')
                            {
                                sum = sum + (number * h);
                            }
                            else if (num[num.Length - 1] == 'D')
                            {
                                sum = sum + (number * d);
                            }
                            else if (num[num.Length - 1] == 'C')
                            {
                                sum = sum + (number * c);
                            }
                        }
                        else if (num.Length < 3)
                        {
                            string temp = num[0].ToString();
                            if (temp == "A")
                            {
                                number = 14;
                            }
                            else if (temp == "K")
                            {
                                number = 13;
                            }
                            else if (temp == "Q")
                            {
                                number = 12;
                            }
                            else if (temp == "J")
                            {
                                number = 11;
                            }
                            else
                            {
                                number = int.Parse(temp);
                            }
                            if (num[num.Length - 1] == 'S')
                            {
                                sum = sum + (number * s);
                            }
                            else if (num[num.Length - 1] == 'H')
                            {
                                sum = sum + (number * h);
                            }
                            else if (num[num.Length - 1] == 'D')
                            {
                                sum = sum + (number * d);
                            }
                            else if (num[num.Length - 1] == 'C')
                            {
                                sum = sum + (number * c);
                            }
                        }

                    }
                }
                Console.WriteLine($"{item.Key}: {sum}");
            }
        }
    }
}
