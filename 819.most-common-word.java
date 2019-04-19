import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 *
 * https://leetcode.com/problems/most-common-word/description/
 *
 * algorithms
 * Easy (42.06%)
 * Total Accepted:    47.3K
 * Total Submissions: 112.5K
 * Testcase Example:  '"Bob hit a ball, the hit BALL flew far after it was hit."\n["hit"]'
 *
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words.  It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation.  Words in the paragraph are not case sensitive.  The answer is
 * in lowercase.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation: 
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent
 * non-banned word in the paragraph. 
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"), 
 * and that "hit" isn't the answer even though it occurs more because it is
 * banned.
 * 
 * 
 * 
 * 
 * Note: 
 * 
 * 
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in
 * paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols
 * !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation
 * symbols.
 * 
 * 
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //basic hashmap implementation
        if(paragraph == null || paragraph.length() == 0) return "";
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        String[] parah = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        HashMap<String, Integer> count = new HashMap<>();
        String max = null;
        for(int i = 0; i < parah.length; i++){
            if(!set.contains(parah[i])){
                if(count.containsKey(parah[i])) count.put(parah[i], count.get(parah[i]) + 1);
                else count.put(parah[i], 1);
            }
        }
        for(Map.Entry<String, Integer> entry: count.entrySet()){
            if(max == null || entry.getValue().compareTo(count.get(max)) > 0){
                max = entry.getKey();
            }
        }

        return max;
    }
}

