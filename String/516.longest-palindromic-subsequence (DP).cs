/*
 * @lc app=leetcode id=516 lang=csharp
 *
 * [516] Longest Palindromic Subsequence
 */
 //DP -- case 1: when i == j s[i] == s[j]
 // ---- case 2: when i != j s[i] == s[j] dp[i][j] == dp[i+1][j-1] + 2
 // ---- case 3: when i != j s[i] != s[j] dp[i + 1][j] == dp[i][j - 1] 
 //Time Complexity : O（n^2), space: O(n^2)
public class Solution {
    public int LongestPalindromeSubseq(string s) {
        
        if(s == null || s.Length < 2) return s.Length;
        int length = s.Length;
        int[,] dp = new int[s.Length, s.Length];

        for(int l = 1; l <= length; l++){
            for(int i = 0; i <= length - l; i++){
                int j = i + l - 1;
                if(i == j){
                    dp[i, j] = 1;
                    continue;
                }
                else{
                    if(s[i] == s[j]){
                        dp[i, j] = dp[i + 1, j - 1] + 2;
                    }
                    else{
                        dp[i, j] = Math.Max(dp[i + 1, j] , dp[i, j - 1]);
                    }
                }
            }
        }

    return dp[0, length - 1]; 
    }
}

