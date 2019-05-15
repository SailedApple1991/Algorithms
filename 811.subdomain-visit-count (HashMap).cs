/*
 * @lc app=leetcode id=811 lang=csharp
 *
 * [811] Subdomain Visit Count
 */
public class Solution {
    public IList<string> SubdomainVisits(string[] cpdomains) {
        Dictionary<string, int> dict = new Dictionary<string, int>();
        foreach(string domain in cpdomains){
            string[] count_info = domain.Split(' ');
            //Console.WriteLine(count_info.Length);
            string[] name = count_info[1].Split('.');
            int count = int.Parse(count_info[0]);
            string cur = "";
            for(int i = name.Length - 1; i >= 0; --i){
                cur = name[i] + (i < name.Length - 1 ? "." : "") + cur;
                int val;
                dict[cur] = dict.TryGetValue(cur, out val) ? val + count : 0 + count;
            }
        }

        List<string> res = new List<string>();
        foreach(string tmp in dict.Keys){
            res.Add(dict[tmp] + " " + tmp);
        }
        return res;
    }
}

