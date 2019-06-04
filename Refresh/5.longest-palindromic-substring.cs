/*
 * @lc app=leetcode id=5 lang=csharp
 *
 * [5] Longest Palindromic Substring
 */
public class Solution {
    public string LongestPalindrome(string s) {
        if(s == null || s.Length < 2) return s;
        int[,] dp = new int[s.Length,s.Length];
        int max = 1, start = 0;
        for(int i = 0; i < s.Length; i++){
            dp[i, i] = 1;
            if(i < s.Length - 1 && s[i] == s[i + 1]){
                dp[i, i + 1] = 2;
                if(max < 2){
                max = dp[i, i + 1];
                start = i;
                }
            }
        }
        for(int j = 0; j < s.Length; j++){
            for(int i = 0; i < j; i++){
                if(i == j) continue;
                else{
                    if(s[i] == s[j] && dp[i + 1, j - 1] != 0){
                        dp[i, j] = dp[i + 1, j - 1] + 2;
                        if(dp[i, j] > max){
                            max = dp[i, j];
                            start = i;
                        }
                    }
                }
            }
        }

        return s.Substring(start, max);
    }
}

