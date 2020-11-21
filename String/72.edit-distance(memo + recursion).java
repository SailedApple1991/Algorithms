/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (45.88%)
 * Likes:    4746
 * Dislikes: 64
 * Total Accepted:    315.7K
 * Total Submissions: 687.8K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        return edit_Distance(word1, word2, 0, 0, memo);
    }

    private int edit_Distance(String word1, String word2, int l1, int l2, int[][] memo){
        if(l1 == word1.length()) return word2.length() - l2;
        if(l2 == word2.length()) return word1.length() - l1;

        if(memo[l1][l2] > 0) return memo[l1][l2];

        char s_c = word1.charAt(l1);
        char t_c = word2.charAt(l2);

        int res = 0;
        if(s_c == t_c){
            return edit_Distance(word1, word2, l1 + 1, l2 + 1, memo);
        }

        int insertVal = edit_Distance(word1, word2, l1, l2 + 1, memo);

        int deleteVal = edit_Distance(word1, word2, l1 + 1, l2, memo);

        int jumpVal = edit_Distance(word1, word2, l1 + 1, l2 + 1, memo);

        res = Math.min(insertVal, Math.min(deleteVal, jumpVal)) + 1;

        memo[l1][l2] = res;
        return res;

    }
}
// @lc code=end

