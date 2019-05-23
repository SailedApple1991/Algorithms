/*
 * @lc app=leetcode id=227 lang=csharp
 *
 * [227] Basic Calculator II
 */
 //no parenthsis
 //Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public int Calculate(string s) {
        //case +， -， *， /
        //use stack to save numbers
        Stack<long> stack = new Stack<long>();
        long res = 0;
        s = s.Replace(" ", string.Empty);
        string firstNum = getNum(0, s);
        long firstnum = Convert.ToInt64(firstNum);
        stack.Push(firstnum);
        int i = firstNum.Length;
        while(i < s.Length){
            char c = s[i];
            //try to get the num first
            string numStr = getNum(i + 1, s);
            long num = Convert.ToInt64(numStr);
            switch(c){
                case ' ': continue;
                case '+':
                    stack.Push(num);
                    break;
                case '-':
                    stack.Push(-num);
                    break;
                case '*':
                    stack.Push(stack.Pop()*num);
                    break;
                case '/':
                    stack.Push(stack.Pop() / num);
                    break;
            }
            i = i + numStr.Length + 1;
        }
        while(stack.Count != 0){
            res += stack.Pop();
        }
        return (int)res;
    }

    private string getNum(int i, string s){
        StringBuilder num = new StringBuilder();
        while(i < s.Length && Char.IsDigit(s[i])){
            num.Append(s[i]);
            i++;
        }
        return num.ToString();
    }
}

