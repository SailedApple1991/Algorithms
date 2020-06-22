/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null) return false; 
        if(s.length() % 2 == 1) return false;
        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length / 2 ;
        while (i < charArray.length / 2){
            if(charArray[i] != charArray[j]) return false;
            i++;
            j++;
        }
        return true;
    }
}
// @lc code=end

