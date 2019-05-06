/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 *
 * https://leetcode.com/problems/valid-number/description/
 *
 * algorithms
 * Hard (13.92%)
 * Total Accepted:    119.5K
 * Total Submissions: 858.6K
 * Testcase Example:  '"0"'
 *
 * Validate if a given string can be interpreted as a decimal number.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one. However, here is a
 * list of characters that can be in a valid decimal number:
 * 
 * 
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * 
 * 
 * Of course, the context of these characters also matters in the input.
 * 
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your
 * function signature accepts a const char * argument, please click the reload
 * button to reset your code definition.
 * 
 */
class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        //tricky way = add one more space to avoid the empty space length == 0 or '+' and i<len check
        int i= 0;
        s = s.trim() + " ";
        char[] sc = s.toCharArray();
        // we add a space, need to subtract one here to retrieve the real length
        int len = s.length() - 1;
        //judge if the first position is a symbol or digit
        if(sc[i] == '+' || sc[i] == '-'){
            //if not judge s.length == 0 , will raise err
            i++;
        }
        //judge a float number -- > at lease one number, at most one point;
        int nDigit = 0, nPoint = 0;
        while(Character.isDigit(sc[i]) || sc[i] == '.'){
            //if only '+''-' will go err
            if(Character.isDigit(sc[i])) {nDigit++;}
            if(sc[i] == '.') {nPoint++;}
            i++;
        }
        if(nDigit <= 0 || nPoint > 1){
            return false;
        }
        //judge 'e'
        if(sc[i] == 'e'){
            i++;
            if(sc[i] == '+' || sc[i] == '-'){
                i++;
            }
            //if + or no, cant stop
            if(i == len) {return false;}
            //judge if the rest are an integer
            for(; i < len; i++){
                if(!Character.isDigit(sc[i])) {return false;}
            }
        }
        //if no e
        return i == len;
        //back to corner case
    }
}

