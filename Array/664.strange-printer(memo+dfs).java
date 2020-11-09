/*
 * @lc app=leetcode id=664 lang=java
 *
 * [664] Strange Printer
 *
 * https://leetcode.com/problems/strange-printer/description/
 *
 * algorithms
 * Hard (40.92%)
 * Likes:    498
 * Dislikes: 51
 * Total Accepted:    16.2K
 * Total Submissions: 39.4K
 * Testcase Example:  '"aaabbb"'
 *
 * 
 * There is a strange printer with the following two special requirements:
 * 
 * 
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and ending
 * at any places, and will cover the original existing characters.
 * 
 * 
 * 
 * 
 * 
 * Given a string consists of lower English letters only, your job is to count
 * the minimum number of turns the printer needed in order to print it.
 * 
 * 
 * Example 1:
 * 
 * Input: "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of
 * the string, which will cover the existing character 'a'.
 * 
 * 
 * 
 * Hint: Length of the given string will not exceed 100.
 */

// @lc code=start
class Solution {
    public int strangePrinter(String s) {
        int l = s.length();
        int[][] t = new int[l][l];
        return helper(s.toCharArray(), 0, l - 1, t);
    }

    private int helper(char[] charArr, int start, int end, int[][] temp){
        if(start > end) return 0;
        if(temp[start][end] >0) return temp[start][end];
        //default/ worst hevavior
        int ans = helper(charArr, start, end - 1, temp) + 1;

        for(int i = start; i < end; i++){
            if(charArr[i] == charArr[end]){
                ans = Math.min(ans, helper(charArr, start, i, temp) + helper(charArr, i + 1, end - 1, temp));
            }
        }

        temp[start][end] = ans;
        return ans;
    }

}
// @lc code=end

