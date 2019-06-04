/*
 * @lc app=leetcode id=772 lang=csharp
 *
 * [772] Basic Calculator III
 */
public class Solution {
    public int Calculate(string s) {
        s = s.Replace(" ", string.Empty);
        Stack<int> nums = new Stack<int>();
        Stack<char> ops = new Stack<char>();
        for(int i = 0; i < s.Length; i++){
            //get the num
            int num = 0, j = 0;
            char c = s[i];
            if(char.IsDigit(c)){
                num = c - '0';
                j  = i + 1;
            while(j < s.Length && char.IsDigit(s[j])){
                num = num * 10 + (s[j] - '0');
                j++;
            }
            nums.Push(num);
            i = j - 1; 
            }
            else if(c == '('){
                ops.Push(c);
            }
            else if(c == ')'){
                while(ops.Peek() != '(' ){
                    nums.Push(operations(ops.Pop(), nums.Pop(), nums.Pop()));
                    
                }
                //pop left paren
                ops.Pop();
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                    if(ops.Count != 0 && previleage(c, ops.Peek())){
                        nums.Push(operations(ops.Pop(), nums.Pop(), nums.Pop()));
                    }
                    ops.Push(c);
            }
        }
        while(ops.Count != 0){
            nums.Push(operations(ops.Pop(), nums.Pop(), nums.Pop()));
        }
        return nums.Pop();
    }

    private int operations(char sign, int num1, int num2){
        switch (sign)
        {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                break;
        }
        return 0;
    }

    private Boolean previleage (char sign1, char sign2){
        if(sign2 == '('|| sign2 == ')'){
            return false;
        }
        if((sign1 == '*' || sign1 == '/') && (sign2 == '+' || sign2 == '-')){
            return false;
        }
        return true;
    }



}

