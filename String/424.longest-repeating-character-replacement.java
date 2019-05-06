/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (43.87%)
 * Total Accepted:    29K
 * Total Submissions: 66.1K
 * Testcase Example:  '"ABAB"\n2'
 *
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Note:
 * Both the string's length and k will not exceed 10^4.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * s = "ABAB", k = 2
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "AABABBA", k = 1
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * 
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, ans = 0, count = 0;
        int[] chars = new int[26];
        while(right < s.length()){
            char endc = s.charAt(right), startc = s.charAt(left);
            chars[endc - 'A']++;
            count = count > chars[endc - 'A'] ? count : chars[endc - 'A'];
            while(right - left + 1 - count > k){
                chars[startc - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}

