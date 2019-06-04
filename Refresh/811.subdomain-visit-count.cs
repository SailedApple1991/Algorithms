/*
 * @lc app=leetcode id=811 lang=csharp
 *
 * [811] Subdomain Visit Count
 */
public class Solution {
    public IList<string> SubdomainVisits(string[] cpdomains) {
        Dictionary<string, int> dict = new Dictionary<string, int>();
        foreach(string str in cpdomains){
            string[] line = str.Split(" ");
            int count = Int32.Parse(line[0]);
            string[] domains = line[1].Split(".");
            string tmp = "";
            for(int i = domains.Length - 1; i >= 0; i--){
                
                tmp = domains[i] + (tmp.Equals("") ? tmp : "." + tmp);
                //Console.WriteLine(tmp);
                if(dict.ContainsKey(tmp)){
                    dict[tmp] = dict[tmp] + count;
                }
                else{
                    dict.Add(tmp, count);
                }
            }
        }
        List<string> res = new List<string>();
        foreach(string key in dict.Keys){
            res.Add(dict[key] + " " + key);
        }
        return res;
    }
}

