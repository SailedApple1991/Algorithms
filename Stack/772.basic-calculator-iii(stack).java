  /*
 * @lc app=leetcode id=772 lang=java
 *
 * [772] Basic Calculator III
 *
 * https://leetcode.com/problems/basic-calculator-iii/description/
 *
 * algorithms
 * Hard (42.46%)
 * Likes:    537
 * Dislikes: 217
 * Total Accepted:    48.5K
 * Total Submissions: 113K
 * Testcase Example:  '"1 + 1"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators , open ( and closing parentheses ) and empty spaces  . The integer
 * division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-2147483648, 2147483647].
 * 
 * Follow up: Could you solve the problem without using built-in library
 * functions.
 * 
 * 
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 * Input: s = " 6-4 / 2 "
 * Output: 4
 * Example 3:
 * Input: s = "2*(5+5*2)/3+(6/2+8)"
 * Output: 21
 * Example 4:
 * Input: s = "(2+6* 3+5- (3*14/7+2)*5)+3"
 * Output: -12
 * Example 5:
 * Input: s = "0"
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s <= 10^4
 * s consists of digits, '+', '-', '*', '/', '(', ')' and ' '.
 * s is a valid expression.
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>(); 

        s = s.replaceAll("\\s+", "");
     
        //System.out.println(i);
        for(int i = 0; i < s.length(); i++){
            //System.out.println(s.length());
            char c = s.charAt(i);
                  //get num 
            if(Character.isDigit(c)){
                  String nextNum = getNum(s, i);
                  int next = Integer.parseInt(nextNum);
                  nums.add(next);
                  i =  i + nextNum.length() - 1;
            }
            
            else{
                //System.out.print("like what");
            switch(c){
                case '(':
                    ops.add(c);
                    break;
                case ')':
                    while(ops.peek() != '('){
                        nums.add(operation(ops.pop(), nums.pop(), nums.pop()));
                    }
                    ops.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!ops.isEmpty() && precedence(c, ops.peek())){
                        nums.add(operation(ops.pop(), nums.pop(), nums.pop()));
                    }
                    ops.push(c);                   
                    break;
                
                default:
                    break;
            }
        }
        }

        while(!ops.isEmpty()){
            nums.add(operation(ops.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }

    private boolean precedence(char op1, Character op2) {
        //judge if order is right or not
        if(op2 == '(' || op2 == ')'){
            return false;
        }

        //higher than the ops in the stack or not -> if low then we go operation
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        }

        return true;
    }

    private Integer operation(Character pop, Integer b, Integer a) {
        switch(pop){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default:
                break;
        }
        return 0;
    }

    private String getNum(String s, int index) {
        Integer num = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            num = num * 10 + s.charAt(index) - '0';
            index ++;
        }
        return num.toString();
    }
}
// @lc code=end

