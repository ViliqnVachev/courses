using System;
using System.Collections.Generic;
using System.Linq;

namespace ParkingValidation
{
    class ParkingValidation
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());            
            Dictionary<string, string> parking = new Dictionary<string, string>();

            for (int i = 0; i < n; i++)
            {
                string[] comands = Console.ReadLine().Split().ToArray();
                string user = comands[1];
                if (comands.Length == 3)
                {
                    char[] tabel = comands[2].ToCharArray();
                   
                    string number = comands[2];
                    string numberValid = "";
                    bool isValid=false;

                    if (parking.ContainsKey(user))
                    {
                        Console.WriteLine($"ERROR: already registered with plate number {parking[user]}");
                        
                    }
                   else if (tabel[0]>='A'&&tabel[0]<='Z'&&tabel[1]>='A'&&tabel[1]<='Z'&& tabel[6] >= 'A' && tabel[6] <= 'Z' && tabel[7] >= 'A' && tabel[7] <= 'Z')
                    {
                        if(tabel[2]>='0'&&tabel[2]<='9'&& tabel[3] >= '0' && tabel[3] <= '9'&& tabel[4] >= '0' && tabel[4] <= '9'&& tabel[5] >= '0' && tabel[5] <= '9')
                        {
                            numberValid=comands[2];
                            isValid = true;
                        }
                        else
                        {
                            Console.WriteLine($"ERROR: invalid license plate {number}");
                            
                        }
                    }
                    else
                    {
                        Console.WriteLine($"ERROR: invalid license plate {number}");
                    }
                    if (isValid == true)
                    {
                        if (parking.ContainsKey(user) == false&&parking.ContainsValue(numberValid)==false)
                        {
                            parking.Add(user, numberValid);
                            Console.WriteLine($"{user} registered {numberValid} successfully");
                        }else if (parking.ContainsValue(numberValid))
                        {
                            Console.WriteLine($"ERROR: license plate {numberValid} is busy");
                        }
                        else if(parking.ContainsKey(user))
                        {
                            Console.WriteLine($"ERROR: already registered with plate number {parking[user]}");
                        }
                       
                    }

                }else if (comands.Length == 2)
                {
                    if (parking.ContainsKey(user) == false)
                    {
                        Console.WriteLine($"ERROR: user {user} not found");
                    }
                    else
                    {
                        Console.WriteLine($"user {user} unregistered successfully");
                        parking.Remove(user);
                    }
                }
            }
            foreach (var item in parking)
            {
                Console.WriteLine($"{item.Key} => {item.Value}");
            }
        }
    }
}
