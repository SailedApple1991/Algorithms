/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */
import java.util.*;
// @lc code=start
class Solution {
    //dp
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for(int i = 1 ; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                //condition
                String sub = s.substring(j, i);
                if(dp[j] && wordDict.contains(sub)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end

