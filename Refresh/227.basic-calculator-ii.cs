/*
 * @lc app=leetcode id=227 lang=csharp
 *
 * [227] Basic Calculator II
 */
public class Solution {
    public int Calculate(string s) {
        s = s.Replace(" ", string.Empty);
        int res;
        Stack<int> nums = new Stack<int>();
        Stack<char> ops = new Stack<char>();
        for(int i = 0; i < s.Length; i++){
            char c = s[i];
            if(char.IsDigit(c)){
                int num = 0;
                while(i < s.Length && char.IsDigit(s[i])){
                    num = num * 10 + (s[i++] - '0');
                }
                nums.Push(num);
                i--;
            }
            else{
               while(ops.Count != 0 && presedence(c, ops.Peek())){
               nums.Push(operation(ops.Pop(), nums.Pop(), nums.Pop())); 
               }
               ops.Push(c);
            }
        }

    while(ops.Count != 0){
        nums.Push(operation(ops.Pop(), nums.Pop(), nums.Pop()));
    }
    return nums.Pop();
    }

    private int operation(char ops, int num1, int num2){
        switch (ops)
        {
            case '+': return num2 + num1;
            case '-': return num2 - num1;
            case '*': return num2 * num1;
            case '/': return num2 / num1;
            default: break;
        }
        return 0;
    }

    private Boolean presedence(char op1, char op2){
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        }
        return true;
    }

}

