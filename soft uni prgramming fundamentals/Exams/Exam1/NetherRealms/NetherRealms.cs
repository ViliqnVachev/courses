using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace NetherRealms
{
    class NetherRealms
    {
        static void Main(string[] args)
        {
            string healthPatrnt = @"[A-Za-z_]";
            string damagePatern = @"-?\d+\.?\d*";
            string asterisPatern = @"[\*]";
            string delPatern = @"[\/]";
            string[] demons = Console.ReadLine().Split(new char[] { ',', ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries).ToArray();
          
            SortedDictionary<string, string> output = new SortedDictionary<string, string>();

            for (int i = 0; i < demons.Length; i++)
            {
                string health = "";
                List<double> damage = new List<double>();
                string asterisk = "";
                string del = "";
                var matchHealth = Regex.Matches(demons[i], healthPatrnt);
                foreach (Match item in matchHealth)
                {
                    health += item.Value;
                }
                var matchDamage = Regex.Matches(demons[i], damagePatern);
                foreach (Match item in matchDamage)
                {
                    damage.Add(double.Parse(item.Value));
                }
                var matchAsterisk = Regex.Matches(demons[i], asterisPatern);
                foreach (Match item in matchAsterisk)
                {
                    asterisk += item.Value;
                }
                var matchDel = Regex.Matches(demons[i], delPatern);
                foreach (Match item in matchDel)
                {
                    del += item.Value;
                }
                int totalHealth = 0;
                for (int h = 0; h < health.Length; h++)
                {
                    totalHealth += health[h];
                }
                string temp = "";

                double damagesum = 0;
                for (int d = 0; d < damage.Count; d++)
                {
                    damagesum += damage[d];
                }
                if (asterisk.Length > 0)
                {
                    damagesum = damagesum * (2 * asterisk.Length);
                }
                if (del.Length > 0)
                {
                    damagesum = damagesum / (2 * del.Length);
                }
                temp = $"{totalHealth} health, {damagesum:F2} damage";

                output.Add(demons[i], temp);
            }

            foreach (var item in output)
            {
                Console.WriteLine($"{item.Key} - {item.Value}");
            }

           
        }
    }
}
