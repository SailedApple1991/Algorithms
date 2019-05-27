 /*
 * @lc app=leetcode id=5 lang=csharp
 *
 * [5] Longest Palindromic Substring
 */
public class Solution {
    public string LongestPalindrome(string s) {
        //DP dp[][]
        //Base Case : dp[i][i] = 1;
        //dp[i][j] = dp[i+1][j-1] + 2 if s[i] == s[j]
        //if s[i] != s[j] then dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])
        if(s == null || s.Length < 2){
            return s;
        }
        int start = 0, max = 1;
        Boolean[,] dp = new Boolean[s.Length, s.Length];
        for(int i = 0; i < s.Length; i++){
            dp[i, i] = true;
            if(i < s.Length - 1){
            dp[i,i + 1] = s[i] == s[i + 1] ? true : false;
            if(dp[i, i + 1]){
                max = 2;
                start = i;
            }
            }
            }
        for(int j = 1; j < s.Length; j++){
            for(int i = 0; i < j; i++){
                    if(s[i] == s[j] && dp[i + 1, j - 1]){
                        dp[i, j] = true;
                        if(max < j - i + 1){
                            max = j - i + 1;
                            start = i;
                        }
                    }
            }
        }
        return s.Substring(start, max);
    }
}

