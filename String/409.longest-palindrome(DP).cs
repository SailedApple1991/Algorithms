/*
 * @lc app=leetcode id=409 lang=csharp
 *
 * [409] Longest Palindrome
 */
public class Solution {
    public int LongestPalindrome(string s) {
        int count = 0;
        bool flag = false;
        int[] charSet = new int[128];
        foreach(char c in s){
            charSet[c] ++;
        }
        for(int i = 0; i < charSet.Length; i++){
            if(charSet[i] > 1){
                if(charSet[i] % 2 == 1){
                count += charSet[i] - 1;
                charSet[i] = 1;
                }
                else{
                    count += charSet[i];
                    charSet[i] = 0;
                }
            }
            if(!flag){
                if(charSet[i] == 1){
                    count++;
                    flag = true;
                }
            }
        }
        return count;
    }
}

