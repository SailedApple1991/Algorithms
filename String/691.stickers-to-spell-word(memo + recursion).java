import jdk.nashorn.internal.ir.debug.PrintVisitor;

/*
 * @lc app=leetcode id=691 lang=java
 *
 * [691] Stickers to Spell Word
 *
 * https://leetcode.com/problems/stickers-to-spell-word/description/
 *
 * algorithms
 * Hard (43.38%)
 * Likes:    438
 * Dislikes: 40
 * Total Accepted:    16.9K
 * Total Submissions: 38.9K
 * Testcase Example:  '["with","example","science"]\n"thehat"'
 *
 * 
 * We are given N different types of stickers.  Each sticker has a lowercase
 * English word on it.
 * 
 * You would like to spell out the given target string by cutting individual
 * letters from your collection of stickers and rearranging them.
 * 
 * You can use each sticker more than once if you want, and you have infinite
 * quantities of each sticker.
 * 
 * What is the minimum number of stickers that you need to spell out the
 * target?  If the task is impossible, return -1.
 * 
 * 
 * Example 1:
 * Input:
 * ["with", "example", "science"], "thehat"
 * 
 * 
 * Output:
 * 3
 * 
 * 
 * Explanation:
 * We can use 2 "with" stickers, and 1 "example" sticker.
 * After cutting and rearrange the letters of those stickers, we can form the
 * target "thehat".
 * Also, this is the minimum number of stickers necessary to form the target
 * string.
 * 
 * 
 * Example 2:
 * Input:
 * ["notice", "possible"], "basicbasic"
 * 
 * 
 * Output:
 * -1
 * 
 * 
 * Explanation:
 * We can't form the target "basicbasic" from cutting letters from the given
 * stickers.
 * 
 * 
 * Note:
 * stickers has length in the range [1, 50].
 * stickers consists of lowercase English words (without apostrophes).
 * target has length in the range [1, 15], and consists of lowercase English
 * letters.
 * In all test cases, all words were chosen randomly from the 1000 most common
 * US English words, and the target was chosen as a concatenation of two random
 * words.
 * The time limit may be more challenging than usual.  It is expected that a 50
 * sticker test case can be solved within 35ms on average.
 * 
 */
import java.util.*;
// @lc code=start
class Solution {
    HashMap<String, Integer> memo;
    public int minStickers(String[] stickers, String target) {
        int length = stickers.length;
        int[][] alphaSet = new int[length][26];
        
        for(int i = 0; i < length; i++){
            alphaSet[i] = convert(stickers[i]);
        }
        memo = new HashMap<>();
        memo.put("", 0);
        return helper(alphaSet, target);

    }

    private int helper(int[][] alphaSet, String target){
        if(memo.containsKey(target)) 
            return memo.get(target);

            int res =  Integer.MAX_VALUE;
            int[] alphaTarget = convert(target);
            for(int[] alpha : alphaSet){
                
                int[] subs = subtract(alphaTarget, alpha);
                if(memo.containsKey(subs)){
                  res = Math.min(res, memo.get(subs) + 1);
                }
                else{
                  res = Math.min(res, helper(alphaSet,  subs) + 1 );
                }
            }

            memo.put(alphaTarget, res);
            return res;
    }
    private int[] convert(String s){
        int[] tmp = new int[26];
        for(char c : s.toCharArray()){
            tmp[c - 'a']++;
        }
        return tmp;
    }


    private int[] subtract(int[] target, int[] arr){
        int[] tmp = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            tmp[i] = Math.max(tmp[i], target[i] - arr[i]);
        }
        return tmp;
    }
}
// @lc code=end

