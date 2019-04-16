/*
 * @lc app=leetcode id=91 lang=csharp
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.13%)
 * Total Accepted:    250.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
public class Solution {
    Dictionary<string, int> map = new Dictionary<string, int>();
    public int NumDecodings(string s) {
        //basic memorization recurtion way
        if(s == null || s.Length == 0) return 0;
        map.Add("", 1);
        return helper(s);
    }

    private int helper(string s){
        if(map.ContainsKey(s)) return map[s];
        if(s[0] == '0') return 0;
        if(s.Length == 1) return 1;

        int count = helper(s.Substring(1));
        int prefix = int.Parse(s.Substring(0, 2));

        if(prefix <= 26){
            count += helper(s.Substring(2));
        }

        map[s] = count;
        return count;
    }
}

