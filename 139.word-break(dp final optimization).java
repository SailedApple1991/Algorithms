/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLength = 0;
        for(String st : wordDict){
            maxLength = maxLength > st.length() ? maxLength : st.length();
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int lastwdLength = 1; lastwdLength <= i && lastwdLength <= maxLength; lastwdLength++){
                if(!dp[i - lastwdLength]) continue;
                if(wordDict.contains(s.substring(i - lastwdLength, i))){
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[s.length()];
    }
}
// @lc code=end

