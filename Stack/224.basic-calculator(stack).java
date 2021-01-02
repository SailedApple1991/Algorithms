/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 *
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (37.65%)
 * Likes:    1865
 * Dislikes: 146
 * Total Accepted:    187.4K
 * Total Submissions: 494.4K
 * Testcase Example:  '"1 + 1"'
 *
 * Given a string s representing an expression, implement a basic calculator to
 * evaluate it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "1 + 1"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * 
 * 
 */

import java.util.*;
// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        int res = 0;
        char[] chaArr = s.toCharArray();
        for(int i = 0; i < chaArr.length; i++){
            char c = chaArr[i];
            if(Character.isDigit(c)){
                //stack.push(stack.pop() * c - '0');
                int num =  c - '0';
                int j  = i + 1;
                while(j < s.length() && Character.isDigit(chaArr[j])){
                    num =  10 * num + (chaArr[j] - '0');
                    j++;
                }
                res += stack.pop() * num;
                i = j - 1;
            }
            //operator
            else if(c == '+' || c == '('){
                stack.push(stack.peek());
            }
            else if(c == '-'){
                stack.push(-1 * stack.peek());
            }
            else if(c == ')'){
                stack.pop();
            }
        }
        return res;
        
    }
}
// @lc code=end

