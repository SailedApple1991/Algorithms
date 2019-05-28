/*
 * @lc app=leetcode id=772 lang=csharp
 *
 * [772] Basic Calculator III
 */
public class Solution {
    public int Calculate(string s) {
        if(s == null || s.Length == 0)return 0;
        Stack<int> nums = new Stack<int>();
        Stack<char> ops = new Stack<char>();
        int num = 0;
        for(int i = 0; i <s.Length; i++){
            char c = s[i];
            if(c == ' ') continue;
            //get the num
            if(char.IsDigit(c)){
                num = c - '0';
                while(i < s.Length - 1 && char.IsDigit(s[i + 1])){
                    num = num * 10 + (s[i + 1] - '0');
                    i++;
                }
                nums.Push(num);
                num = 0;
            }
            //left parenthesis
            else if(c == '('){
                ops.Push(c);
            }
            //right parentesis 
            else if(c == ')'){
                while(ops.Peek() != '('){
                    nums.Push(operation(ops.Pop(), nums.Pop(), nums.Pop()));
                }
                //get the left parenthesis out
                ops.Pop();
            }
            //operators
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                while(ops.Count != 0 && precedence(c, ops.Peek())){
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

    private int operation(char op, int b, int a){
        switch(op){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    private Boolean precedence(char op1, char op2){
        //not right order
        if(op2 == '(' || op2 == ')'){
            return false;
        }

        //higher than the ops in stack or not -> low then we go operation 
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        }

        return true;
    }
    private string getNum(int i, string s){
        int num = 0;
        while(i < s.Length && Char.IsDigit(s[i])){
            num = num * 10 + (s[i] - '0');
            i++;
        }
        return num.ToString();
    }
}

