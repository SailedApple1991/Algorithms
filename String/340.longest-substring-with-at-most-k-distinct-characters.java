/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 *
 * algorithms
 * Hard (39.40%)
 * Total Accepted:    70.8K
 * Total Submissions: 179.7K
 * Testcase Example:  '"eceba"\n2'
 *
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 * 
 * 
 * 
 */
// class Solution {
//     public int lengthOfLongestSubstringKDistinct(String s, int k) {
//         //two pointers brUte force
//         if(s == null || s.length() == 0 || k == 0) return 0;
//         HashMap<Character, Integer> count = new HashMap<>();
//         int left =0, right = 0, maxLength = 0, beginIndex = 0, max = 0;
//         char c;
//         while(left < s.length()){
//             while(right < s.length()){
//             //while max is met k, update left, compare max and right - left + 1, is max is smaller, update the max and start index;
//             //while max is not met k, expand right cursor
//             c = s.charAt(right);
//             if(count.containsKey(c)){
//                 count.put(c, count.get(c) + 1);
//             }
//             else{
//                 if(count.size() == k) break;
//                 count.put(c, 1);
//             }
//             right++;
            
//             } 
//             maxLength = Math.max(maxLength, right - left);
            
//             c = s.charAt(left);
//             if(count.containsKey(c) ){
//                 if(count.get(c) > 1){
//                     count.put(c, count.get(c) - 1);
//                 }
//                  else{
//                 count.remove(c);
//             }
//             }
//             left++;
//             }
            
//         return maxLength;
//     }
// }
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //slicing window methods
        if(s == null || s.length() == 0 ||  k == 0) return 0;
        int left = 0, right = 0, maxLength = 0, num = 0;
        char[] count = new char[256];
        char c;
        while(right < s.length()){
            //if the element never seen before, add distict number
            c = s.charAt(right);
            if(count[s.charAt(right)]== 0){
                num++;
            }
            //add one in the count arr
            count[c]++;

            //if num of distinct num more than k, subtract it until k and move left cursor
            while(num > k){
                c = s.charAt(left);
                count[c]--;
                //if no left element in the arr, dinctinct nums subtract 1
                if(count[c] == 0) num--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
            }
            return maxLength;
        }
    }


