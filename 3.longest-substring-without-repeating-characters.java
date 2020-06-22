import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
//slice window O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == "") return 0;
        HashMap<Character, Integer> strMet = new HashMap<Character, Integer>();
        int left = -1, right = 0, res = 0;
        while(right < s.length()){
            char cur = s.charAt(right);
            if(strMet.containsKey(cur)){
                if(strMet.get(cur) > left){
                    left =strMet.get(cur);
                    //strMet.put(cur, right);
                }
            }
            strMet.put(cur, right);
            res = Math.max(res, right - left);
            //compare right
            right++;

        }
        return res;
    }
}
// @lc code=end

