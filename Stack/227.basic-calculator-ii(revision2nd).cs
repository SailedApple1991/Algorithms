 /*
 * @lc app=leetcode id=227 lang=csharp
 *
 * [227] Basic Calculator II
 */
public class Solution {
    public int Calculate(string s) {
        int result = 0;
        Stack<int> stack = new Stack<int>();
        s = s.Replace(" ", string.Empty);
        string firstNum = getNum(0, s);
        int firstnum = Convert.ToInt32(firstNum);
        stack.Push(firstnum);
        int i = firstNum.Length;
        while(i < s.Length){
            char c = s[i];
            string numStr = getNum(i + 1, s);
            int num = Convert.ToInt32(numStr);
            switch (c){
                case ' ': continue;
                case '+':
                    stack.Push(num);
                    break;
                case '-':
                    stack.Push(- num);
                    break;
                case '*':
                    stack.Push(stack.Pop() * num);
                    break;
                case '/':
                    stack.Push(stack.Pop() / num);
                    break;
            }
            i = i + numStr.Length + 1;
        }
        while(stack.Count != 0){
            result += stack.Pop();
        }

        return result;
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

