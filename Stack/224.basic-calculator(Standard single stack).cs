/*
 * @lc app=leetcode id=224 lang=csharp
 *
 * [224] Basic Calculator
 */
public class Solution {
    public int Calculate(string s) {
        long number = 0, result = 0; 
        long sigh = 1;
        Stack<long> stack = new Stack<long>();
        for(int i = 0; i < s.Length; i++){
            char c = s[i];
            if(c == ' ') continue;
            else if(Char.IsDigit(c)){
                number = number * 10 + (long)(c - '0');
            }
            else if(c == '+'){
                result += sigh * number;
                sigh = 1;
                number = 0;
            }
            else if(c == '-'){
                result += sigh * number;
                sigh = -1;
                number = 0;
            }
            else if(c == '('){
                stack.Push(result);
                stack.Push(sigh);
                sigh = 1;
                result = 0;
            }
            else if(c == ')'){
                result += sigh * number;
                number = 0;
                //calculate the sigh
                result *= stack.Pop();
                //calculate the number
                result += stack.Pop();
            }
        }
        if(number != 0){
            result += number * sigh;
        }

        return (int)result;
    }

}

