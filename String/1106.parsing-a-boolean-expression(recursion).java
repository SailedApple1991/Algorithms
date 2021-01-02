 /*
 * @lc app=leetcode id=1106 lang=java
 *
 * [1106] Parsing A Boolean Expression
 *
 * https://leetcode.com/problems/parsing-a-boolean-expression/description/
 *
 * algorithms
 * Hard (58.96%)
 * Likes:    308
 * Dislikes: 19
 * Total Accepted:    12.1K
 * Total Submissions: 20.5K
 * Testcase Example:  '"!(f)"'
 *
 * Return the result of evaluating a given boolean expression, represented as a
 * string.
 * 
 * An expression can either be:
 * 
 * 
 * "t", evaluating to True;
 * "f", evaluating to False;
 * "!(expr)", evaluating to the logical NOT of the inner expression expr;
 * "&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner
 * expressions expr1, expr2, ...;
 * "|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner
 * expressions expr1, expr2, ...
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: expression = "!(f)"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: expression = "|(f,t)"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: expression = "&(t,f)"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: expression = "|(&(t,f,t),!(t))"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= expression.length <= 20000
 * expression[i] consists of characters in {'(', ')', '&', '|', '!', 't', 'f',
 * ','}.
 * expression is a valid expression representing a boolean, as given in the
 * description.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean parseBoolExpr(String expression) {
        /*
        t -> true
        f -> false
        '!' -> !parse(e, ++s)
        '&' -> true and parse(e, ++s) & parse (e, ++s) until e[s] = ')'
        '|' -> false | parse(e, ++s) or parse (e, ++s) until e[s] = ')'
        o(n)
        o(n)
        */
        int start = 2, end =  expression.length() - 1;
        char c = expression.charAt(0);
        if(c == '!'){
            return !parseBoolExpr(expression.substring(start, end  ));
        }
        else if(c == '|'){
            System.out.println("1");
            return parseHelper(expression.substring(start, end), false);
        }
        else if(c == '&'){
            return parseHelper(expression.substring(start, end), true);
        }
        else{
             System.out.println("0");
            return expression == "t";
        }
    }

    private boolean parseHelper(String expression, Boolean and) {
        int count = 0, start = 0;
        boolean ret = true;
        for(int i = 0; i < expression.length(); i++){
            if(i == expression.length() -1 || (expression.charAt(i) == ',' && count == 0)){
                String prefix = expression.substring(start, i);
                System.out.println(prefix);
                if(start == 0){
                    //gain the init value
                    ret = parseBoolExpr(prefix);
                    System.out.println("3");
                }
                else if(and){
                    ret = ret && parseBoolExpr(prefix);
                }
                else{
                    System.out.println("4");
                    ret = ret || parseBoolExpr(prefix);
                }
                start = i + 1;
            }
            else if(expression.charAt(i) == '('){
                System.out.println("2");
                count++;
            }
            else if(expression.charAt(i) == ')'){
                System.out.println("5");
                count--;
            }
            
        }
        return ret;
    }
}


// @lc code=end

