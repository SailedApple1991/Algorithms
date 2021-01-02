
/*
 * @lc app=leetcode id=1087 lang=java
 *
 * [1087] Brace Expansion
 *
 * https://leetcode.com/problems/brace-expansion/description/
 *
 * algorithms
 * Medium (63.01%)
 * Likes:    295
 * Dislikes: 33
 * Total Accepted:    24.6K
 * Total Submissions: 39.1K
 * Testcase Example:  '"{a,b}c{d,e}f"'
 *
 * A string S represents a list of words.
 * 
 * Each letter in the word has 1 or more options.  If there is one option, the
 * letter is represented as is.  If there is more than one option, then curly
 * braces delimit the options.  For example, "{a,b,c}" represents options ["a",
 * "b", "c"].
 * 
 * For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde",
 * "bdf", "cde", "cdf"].
 * 
 * Return all words that can be formed in this manner, in lexicographical
 * order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "abcd"
 * Output: ["abcd"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 50
 * There are no nested curly brackets.
 * All characters inside a pair of consecutive opening and ending curly
 * brackets are different.
 * 
 * 
 */
import java.util.*;

// @lc code=start
class Solution {
    public String[] expand(String S) {
        if (S == null || S.length() == 0)
            return new String[0];

        List<String> res = new ArrayList<String>();
        dfs(S, 0, new StringBuilder(), res);
        Collections.sort(res);
        return res.toArray(new String[0]);
    }

    private void dfs(String s, int index, StringBuilder stringBuilder, List<String> res) {
        if(index >= s.length()){
            res.add(stringBuilder.toString());
            return;
        }
        if(s.charAt(index) == '{'){
            int j = index + 1;
            while(j < s.length() && s.charAt(j) != '}'){
                j++;
            }

        String[] candidate = s.substring(index + 1, j).split(",");

        for(int i = 0; i < candidate.length; i++){
            stringBuilder.append(candidate[i]);
            dfs(s, j + 1, stringBuilder, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        else{
            stringBuilder.append(s.charAt(index));
            dfs(s, index + 1, stringBuilder, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    
}
// @lc code=end

