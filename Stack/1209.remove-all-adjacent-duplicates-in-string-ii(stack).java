/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/
 *
 * algorithms
 * Medium (57.34%)
 * Likes:    907
 * Dislikes: 24
 * Total Accepted:    55.6K
 * Total Submissions: 96.8K
 * Testcase Example:  '"abcd"\n2'
 *
 * Given a string s, a k duplicate removal consists of choosing k adjacent and
 * equal letters from s and removing them causing the left and the right side
 * of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * 
 * Example 2:
 * 
 * 
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation: 
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 * 
 * 
 */

import java.util.*;
// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for(int i = 0; i < sb.length(); i++){
            if(i == 0 || sb.charAt(i) != sb.charAt( i - 1)){
                counts.push(1);
            }
            else{
                int intcre = counts.pop() + 1;
                if(intcre == k){
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
                else{
                    counts.push(intcre);
                }
            }
        }       
        return sb.toString();
    }
}
// @lc code=end

