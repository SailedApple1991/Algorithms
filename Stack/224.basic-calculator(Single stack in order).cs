/*
 * @lc app=leetcode id=224 lang=csharp
 *
 * [224] Basic Calculator
 */
 //Single Stack -- inflix -  post order flix transform calculation
public class Solution {
    public int Calculate(string s) {
        Stack<int> stack = new Stack<int>();
        //pre push 2 value incase null stack
        stack.Push(1);
        stack.Push(1);
        int res = 0;
        for(int i = 0; i < s.Length; i++){
            char c = s[i];
            //digit
            if(Char.IsDigit(c)){
                int num = c - '0';
                int j = i + 1;
                //get the num
                while(j < s.Length && Char.IsDigit(s[j])){
                    num = 10 * num + (s[j] - '0');
                    j++;
                }
                res +=  stack.Pop() * num;
                i = j - 1;
            }
            //operator

            else if(c == '+' || c == '('){
                stack.Push(stack.Peek());
            }
            else if(c == '-'){
                stack.Push(-1 * stack.Peek());
            }
            else if(c == ')'){
                stack.Pop();
            }
        }
        return res;
    }
}

