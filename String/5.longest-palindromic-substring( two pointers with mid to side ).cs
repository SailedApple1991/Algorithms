/*
 * @lc app=leetcode id=5 lang=csharp
 *
 * [5] Longest Palindromic Substring
 */
 //two pointers with odd or even corner case 
 //Time Complexity : O(n^2), space Complexity: O(1)
public class Solution {
    public string LongestPalindrome(string s) {
        int length = s.Length;
        if(length < 2) return s;
        int start = 0, maxLen = 0;
        for(int i = 1; i < length; i++){
            //odd case right - left == 1
            int left = i - 1, right = i;
            while(left >= 0 && right < length && s[left] == s[right]){
                left--; 
                right++;
            }
            if(maxLen < right - left -1 ){
                maxLen = right - left - 1;
                start = left + 1;
            }



            // even case right 
             left = i - 1; right = i + 1;
            while(left >= 0 && right < length && s[left] == s[right]){
                left--;
                right++;
            }
            if(maxLen < right - left - 1){
                maxLen = right - left - 1;
                start = left + 1;
            }

        }
        return s.Substring(start, maxLen);
    }
}

