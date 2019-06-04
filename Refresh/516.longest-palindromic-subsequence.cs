/*
 * @lc app=leetcode id=516 lang=csharp
 *
 * [516] Longest Palindromic Subsequence
 */
public class Solution {
    public int LongestPalindromeSubseq(string s) {
        if(s == null || s.Length < 2) return s.Length;
        int[,] dp = new int[s.Length, s.Length];
        int max = 1;
        for(int i = 0; i < s.Length; i++){
            dp[i, i] = 1;
            if(i < s.Length - 1 && s[i] == s[i + 1]){
                dp[i, i + 1] = 2;
                max = 2;
            }
            if(i < s.Length - 1 && s[i] != s[i + 1]){
                dp[i, i + 1] = 1;
            }
        }

        // for(int j = 2; j < s.Length; j++){
        //     for(int i = 0; i < j; i++){
        // wrong. Some case cannot fully cover
        for(int len = 1; len <= s.Length; len++){
            for(int i = 0; i <= s.Length - len; i++){
                int j = i + len - 1; 
                if(i == j) continue;        
                if(s[i] == s[j]){
                    dp[i, j] = dp[i + 1, j - 1] + 2;
                    
                }
                if(s[i] != s[j]){
                    dp[i, j] = Math.Max(dp[i + 1, j], dp[i, j - 1]);
                }

                max = Math.Max(max, dp[i, j]);
            }
        }

        return max;
    }
}

