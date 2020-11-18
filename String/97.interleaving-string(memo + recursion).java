/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 *
 * https://leetcode.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (32.07%)
 * Likes:    1718
 * Dislikes: 97
 * Total Accepted:    167.5K
 * Total Submissions: 521.3K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving
 * of s1 and s2.
 * 
 * An interleaving of two strings s and t is a configuration where they are
 * divided into non-empty substrings such that:
 * 
 * 
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 +
 * t3 + s3 + ...
 * 
 * 
 * Note: a + b is the concatenation of strings a and b.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lower-case English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    //memo + recurtion
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(s1, s2, 0, 0, s3, 0, memo);
    }

    private boolean helper(String s1, String s2, int l1, int l2, String s3, int l3, Boolean[][] memo){
        if(l1 + l2 == s3.length()) return true;

        if(memo[l1][l2] != null) return memo[l1][l2];
        boolean ans = false;

        if( l1 < s1.length() && s1.charAt(l1) == s3.charAt(l3)){
            ans = helper(s1, s2, l1 + 1, l2, s3, l3 + 1, memo); 
        }
        if( l2 < s2.length() && s2.charAt(l2) == s3.charAt(l3)){
            ans |= helper(s1, s2, l1, l2 + 1, s3, l3 + 1, memo);
        }

        memo[l1][l2] = ans;
        return ans;
        
    }
}
// @lc code=end

