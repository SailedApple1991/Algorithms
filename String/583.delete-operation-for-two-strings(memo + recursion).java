/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * algorithms
 * Medium (49.34%)
 * Likes:    1272
 * Dislikes: 30
 * Total Accepted:    56.4K
 * Total Submissions: 114.2K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * 
 * Given two words word1 and word2, find the minimum number of steps required
 * to make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * 
 * Example 1:
 * 
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to
 * make "eat" to "ea".
 * 
 * 
 * 
 * Note:
 * 
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    //memo + recursion
    /*
    1307/1307 cases passed (11 ms)
    Your runtime beats 16.2 % of java submissions
    Your memory usage beats 13.27 % of java submissions (40.1 MB)
    */
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        return helper(word1, word2, 0, 0 , cache);
    }

    private int helper(String word1, String word2, int i, int j, int[][] cache){
        if(i == word1.length()||j == word2.length()){
            return word1.substring(i).length() + word2.substring(j).length();
        }

        if(cache[i][j] != 0){
            return cache[i][j];
        }

        int res = 0;

        if(word1.charAt(i) == word2.charAt(j)){
            return helper(word1, word2, i + 1, j + 1, cache);
        }

        else{
            res = Math.min(helper(word1, word2, i + 1, j, cache) + 1, helper(word1, word2, i, j + 1, cache) + 1);
        }

        cache[i][j] = res;

        return res;


    }
}
// @lc code=end

