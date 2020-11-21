import sun.security.util.Length;

/*
 * @lc app=leetcode id=712 lang=java
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 *
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
 *
 * algorithms
 * Medium (58.97%)
 * Likes:    1125
 * Dislikes: 50
 * Total Accepted:    40.2K
 * Total Submissions: 68.2K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to
 * make two strings equal.
 * 
 * Example 1:
 * 
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to
 * the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum
 * possible to achieve this.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e]
 * to the sum.
 * At the end, both strings are equal to "let", and the answer is
 * 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers
 * of 433 or 417, which are higher.
 * 
 * 
 * 
 * Note:
 * 0 < s1.length, s2.length .
 * All elements of each string will have an ASCII value in [97, 122]. 
 * 
 */

// @lc code=start
class Solution {
    //memo + recursion
    public int minimumDeleteSum(String s1, String s2) {
        
        int[][] cache = new int[s1.length()][s2.length()];

        return helper(s1, s2, 0, 0, cache);
    }

    private int helper(String s1, String s2, int i, int j, int[][] cache){
        if(i == s1.length() || j == s2.length()){
            return calSubstringASC(s1.substring(i)) + calSubstringASC(s2.substring(j));
        }
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        int res = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            return helper(s1, s2, i + 1, j + 1, cache);
        }
        else{
            res = Math.min(helper(s1, s2, i + 1, j, cache) + (int)s1.charAt(i), helper(s1, s2, i, j + 1, cache) + (int)s2.charAt(j));
        }
        cache[i][j] = res;

        return res;
    }

    private int calSubstringASC(String s){
        int res = 0;
        for(char c : s.toCharArray()){
            res += (int)c;
        }
        return res;
    }
}
// @lc code=end

