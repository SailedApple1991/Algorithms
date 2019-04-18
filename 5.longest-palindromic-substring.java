/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.01%)
 * Total Accepted:    525K
 * Total Submissions: 1.9M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
// class Solution {
//     public String longestPalindrome(String s) {
//         //two pointer opposite side
//         int beginIndex = 0, length = 0, max = 0;

//         for(int middle = 0; middle < s.length(); middle++){
//             // two case
//             //odd
//             length = PalindromeLength(s, middle, middle + 1);
//             //judge
//             if(length > max){
//                 max = length;
//                 beginIndex = middle - length / 2 + 1;
//             }
//             //even
//             length = PalindromeLength(s, middle, middle);
//             //judge
//             if(length > max){
//                 max = length;
//                 beginIndex = middle - length / 2;
//             }
//         }
//         return s.substring(beginIndex, beginIndex + max);
//     }

//     private int PalindromeLength(String s, int left, int right){
//         int length = 0;
//         while(left >= 0 && right <= s.length() - 1){
//             if(s.charAt(left) != s.charAt(right)) break;
//             //need to consider if odd case or even
//             length += left == right ? 1 : 2;
//             left--;
//             right++;
//         }

//         return length;
//     }
// }


class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int beginIndex = 0, max = 1, n = s.length();;

        //dp boolean matrix 
        boolean[][] palindrome = new boolean[n][n];
        //one str and 2 trs deal with the odd and even -> base case
        for(int i = 0; i < n; i++){
            palindrome[i][i] = true;
        }

        for(int i = 0; i < n - 1; i++){
            palindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if(palindrome[i][i + 1]){
                beginIndex = i;
                max = 2;
            }
        }

        // multi length case bottom up
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 2; j < n; j++){
                //use base case update condition
                palindrome[i][j] = palindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);

                if(palindrome[i][j] && j - i + 1 > max){
                    beginIndex = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + max);
    }

 
}
