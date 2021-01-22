import org.graalvm.compiler.replacements.nodes.AssertionNode;

/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 *
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 *
 * algorithms
 * Medium (59.95%)
 * Likes:    573
 * Dislikes: 12
 * Total Accepted:    18.3K
 * Total Submissions: 30.4K
 * Testcase Example:  '"abcabc"'
 *
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab",
 * "bcabc", "cab", "cabc" and "abc" (again). 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "aaacb", "aacb" and "acb". 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "abc"
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 * 
 * 
 */

// @lc code=start
//slicing window
class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] count = new int[3];
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char charEnd = s.charAt(end);
            count[charEnd - 'a'] ++;
            while(count[0] >= 1 && count[1] >= 1 && count[2] >= 1){
                ans += s.length() - end;
                char charStart = s.charAt(start);
                count[charStart -'a'] --;
                start++;
            }
        }
        return ans;
    }
}
// @lc code=end

