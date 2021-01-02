import java.util.Stack;

/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (28.50%)
 * Likes:    2873
 * Dislikes: 124
 * Total Accepted:    164.7K
 * Total Submissions: 576.9K
 * Testcase Example:  '"1432219"\n3'
 *
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
            if(num.length() == k){
                return "0";
            }
                Stack<Integer> stack = new Stack<Integer>();
            char[] charArr= num.toCharArray();
            for(char c : charArr){
                while(!stack.isEmpty() && k > 0 && stack.peek() > Character.getNumericValue(c)){
                    stack.pop();
                    k--;
                }
                if(stack.isEmpty()&& c =='0') continue;
                stack.add(Character.getNumericValue(c));
            }

            while(k > 0){
                stack.pop();
                k--;
            }
            if(stack.isEmpty()){
                return "0";
            }
            StringBuilder sb=new StringBuilder();
            while(stack.size()>0) sb.append(stack.pop());
            sb.reverse();
            return sb.toString();

        }   
    }

// @lc code=end

