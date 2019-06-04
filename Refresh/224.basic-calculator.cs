/*
 * @lc app=leetcode id=224 lang=csharp
 *
 * [224] Basic Calculator
 */
public class Solution {
    public int Calculate(string s) {
        s = s.Replace(" ", string.Empty);
        int res = 0, sign  = 1;
        Stack<int> ops = new Stack<int>();
    
        for(int i = 0; i < s.Length; i++){
            //judge if is digit -- get the num
            char c = s[i];
            if(char.IsDigit(c)){
                int num = c - '0';
                int j = i + 1;
                while(j < s.Length && char.IsDigit(s[j])){
                    num = num * 10 + (s[j] - '0');
                    j++;
                }
                 res += sign * num;
                 i = j - 1;
            }

            switch(c){
                case '+':
                    sign = 1;
                     break;
                case '-':
                    sign = -1;
                    break;
                case '(':
                    ops.Push(res);
                    ops.Push(sign);
                    res = 0;
                    sign = 1;
                    break;
                case ')':
                    res *= ops.Peek();
                    ops.Pop();
                    res += ops.Peek();
                    ops.Pop();
                    break;
                
            }

        }
       
        return res;
    }
}

