/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (37.60%)
 * Likes:    1987
 * Dislikes: 320
 * Total Accepted:    236.3K
 * Total Submissions: 619.2K
 * Testcase Example:  '"3+2*2"'
 *
 * Given a string s which represents an expression, evaluate this expression
 * and return its value. 
 * 
 * The integer division should truncate toward zero.
 * 
 * 
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s consists of integers and operators ('+', '-', '*', '/') separated by some
 * number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range
 * [0, 2^31 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int calculate(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        s = s.replaceAll("\\s+", "");
        String firstNumStr = getNum(s, 0);
        stack.push(Integer.parseInt(firstNumStr));
        int i = firstNumStr.length();
        while(i < s.length()){
            char c = s.charAt(i);
            String nextNum = getNum(s, i + 1);
            int num = Integer.parseInt(nextNum);
            switch(c){
                case '+':
                    stack.add(num);
                    break;
                case '-':
                    stack.add(-num);
                    break;
                case '*':
                    stack.add( stack.pop() * num);
                    break;
                case '/':
                    stack.add(stack.pop() / num);
                    System.out.print("hey");
                    break;
                default:
                    continue;
            }
            i =  i + nextNum.length() + 1;
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        
        return res;

    }

    private String getNum(String s, int left){
        Integer num = 0;
        while(left < s.length() && Character.isDigit(s.charAt(left))){
            num = num * 10 + s.charAt(left) - '0';
            left++;
        }
        return num.toString();
    }
}
// @lc code=end

