using System;
using System.Collections.Generic;

namespace Phonebook
{
    class Phonebook
    {
        static void Main(string[] args)
        {
            string[] comands = Console.ReadLine().Split();
            SortedDictionary<string, string> book = new SortedDictionary<string, string>();

            while (comands[0] != "END")
            {
                if (comands[0] == "A")
                {
                    if (book.ContainsKey(comands[1]) == false)
                    {
                        book.Add(comands[1], comands[2]);
                    }
                    book[comands[1]] = comands[2];

                }
                else if (comands[0] == "S")                    
                {
                    string temp;
                    
                        if (book.ContainsKey(comands[1]))
                        {
                       

                            Console.WriteLine($"{comands[1]} -> {book[comands[1]]}");
                            
                        }
                        else
                        {
                            Console.WriteLine($"Contact {comands[1]} does not exist.");
                         }              
                    
                }
                else if (comands[0] == "ListAll")
                {
                    foreach (var item in book)
                    {
                        Console.WriteLine($"{item.Key} -> {item.Value}");
                    }
                }
                comands = Console.ReadLine().Split();
            }
        }
    }
}
