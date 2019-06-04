/*
 * @lc app=leetcode id=409 lang=csharp
 *
 * [409] Longest Palindrome
 */
public class Solution {
    public int LongestPalindrome(string s) {
        int[] charSet = new int[128];
        int evenCount = 0, oddCount = 0;
        foreach(char c in s){
            if(c >= 97){
                charSet[26 + c - 'a']++;
            }
            else{
                 charSet[c - 'A']++;
            }
        }
        foreach(int cnt in charSet){
            if(cnt % 2 == 0){
                evenCount += cnt;
            }
            else{
                if(cnt == 1){
                    oddCount++;
                }
                else if(cnt > 1){
                    evenCount += cnt - 1;
                    oddCount++;
                }
            }
        }

        if(oddCount > 0){
            evenCount += 1;
        }

        return evenCount;
    }
}

