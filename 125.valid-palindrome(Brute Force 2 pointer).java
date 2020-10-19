/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().replaceAll("[^A-Za-z0-9]", "").replaceAll(" ", "").toLowerCase();
        System.out.println(s);
        int i = 0, j = s.length() - 1;
        while(i < j){
            System.out.println(s.charAt(i));
            System.out.println(s.charAt(j));
            System.out.println("-------------------");
            if(s.charAt(i) != s.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
// @lc code=end

