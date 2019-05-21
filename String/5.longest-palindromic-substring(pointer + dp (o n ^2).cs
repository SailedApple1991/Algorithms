/*
 * @lc app=leetcode id=5 lang=csharp
 *
 * [5] Longest Palindromic Substring
 */
 //two pointer and boolean matrix dp time complexity O(n ^ 2)
public class Solution {
    public string LongestPalindrome(string s) {
        if(s == null || s.Length < 2) return s;

        int left = 0, right = 0;
        Boolean[,] isPalindrome = new Boolean[s.Length, s.Length];
        for(int j = 1; j < s.Length; j++){
            for(int i = 0; i < j; i++){
                Boolean isInnerWordPalindrome = isPalindrome[i + 1, j - 1] || j - i <= 2;
                 if(s[i] == s[j] && isInnerWordPalindrome){
                    isPalindrome[i, j] = true;

                    if(j - i > right - left){
                    left = i;
                    right = j;
                }
                }
            }
        }
      
        return s.Substring(left, right - left + 1);
    }
}

