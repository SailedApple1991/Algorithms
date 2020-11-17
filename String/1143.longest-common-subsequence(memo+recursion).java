/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 *
 * https://leetcode.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (58.48%)
 * Likes:    2170
 * Dislikes: 28
 * Total Accepted:    154.2K
 * Total Submissions: 263.4K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative
 * order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
 * while "aec" is not). A common subsequence of two strings is a subsequence
 * that is common to both strings.
 * 
 * 
 * 
 * If there is no common subsequence, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m =  text1.length() - 1, n =  text2.length() - 1;
        int[][] memo =  new int[m + 1][n + 1];
        return helper(text1, text2, m, n, memo);
    }

    private int helper(String str1, String str2, int i, int j, int[][] memo){
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] > 0) return memo[i][j];
        int res = 0;
        if(str1.charAt(i) == str2.charAt(j)){
            res = helper(str1, str2, i - 1, j - 1, memo) + 1;
        }
        else{
            res = Math.max(helper(str1, str2, i - 1, j, memo), helper(str1, str2, i, j - 1, memo));
        }
        memo[i][j] = res;
        return res;
    }
}
// @lc code=end

