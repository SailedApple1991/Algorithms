/*
 * @lc app=leetcode id=1312 lang=java
 *
 * [1312] Minimum Insertion Steps to Make a String Palindrome
 *
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 *
 * algorithms
 * Hard (58.80%)
 * Likes:    548
 * Dislikes: 7
 * Total Accepted:    17.6K
 * Total Submissions: 29.8K
 * Testcase Example:  '"zzazz"'
 *
 * Given a string s. In one step you can insert any character at any index of
 * the string.
 * 
 * Return the minimum number of steps to make s palindrome.
 * 
 * A Palindrome String is one that reads the same backward as well as
 * forward.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any
 * insertions.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "g"
 * Output: 0
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "no"
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 500
 * All characters of s are lower case English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        //memo + recursion
        /*
        1) if arr[i] == arr[j] helper(i, j) = helper(i + 1, j - 1)
        2) if arr[i] != arr[j] helper(i, j) = min(helper(i + 1, j) , helper(i, j - 1)) + 1
        */
        int length = s.length();
        int[][] memo = new int[length][length];
        char[] charArr = s.toCharArray();
        return helper(charArr, 0, length - 1, memo);
    }

    private int helper(char[] charArr, int i, int j, int[][] memo){
        if(i >= j) return 0;

        if(memo[i][j] != 0) return memo[i][j];

        int count = 0;
        
        if(charArr[i] == charArr[j]){
            count = helper(charArr, i + 1, j - 1, memo);
        }
        else{
            count = Math.min(helper(charArr, i + 1, j, memo), helper(charArr, i, j - 1, memo)) + 1;
        }

        memo[i][j] = count;

        return count;
    }
}
// @lc code=end

