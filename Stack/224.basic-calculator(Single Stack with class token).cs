/*
 * @lc app=leetcode id=224 lang=csharp
 *
 * [224] Basic Calculator
 */
// 复杂度
// 时间 O(N) 空间 O(N)

// 思路
// 很多人将该题转换为后缀表达式后（逆波兰表达式）求解，其实不用那么复杂。
// 题目条件说明只有加减法和括号，由于加减法是相同顺序的，我们大可以直接把所有
// 数顺序计算。难点在于多了括号后如何处理正负号。我们想象一下如果没有括号这题
// 该怎们做：因为只有加减号，我们可以用一个变量sign来记录上一次的符号是加还是
// 减，这样把每次读到的数字乘以这个sign就可以加到总的结果中了。有了括号后，整
// 个括号内的东西可一看成一个东西，这些括号内的东西都会受到括号所在区域内的正
// 负号影响（比如括号前面是个负号，然后括号所属的括号前面也是个负号，那该括号
// 的符号就是正号）。但是每多一个括号，都要记录下这个括号所属的正负号，而每当
// 一个括号结束，我们还要知道出来以后所在的括号所属的正负号。根据这个性质，我
// 们可以使用一个栈，来记录这些括号所属的正负号。这样我们每遇到一个数，都可以
// 根据当前符号，和所属括号的符号，计算其真实值。
public class Solution {
    public int Calculate(string s) {
        s = s.Trim();
        Stack<int> stack = new Stack<int>();
        //push 1 first, understand as a large parenthis at the very out border
        stack.Push(1);
        int i = 0, res = 0, sign = 1;
        while(i < s.Length){
            char c = s[i];
            //if we get +, set current sign to positive
            if(c == '+'){
                sign = 1;
                i++;
            }
            //if we get -, set current sign to negative
            else if( c == '-'){
                sign = -1;
                i++;
            }
            //if we get left parenthsis, push into stack while calcuating the sign
            else if(c == '('){
                stack.Push(stack.Peek() * sign);
                sign = 1;
                i++;
            }
            //if we get right parenthsis, pop the current element
            else if( c == ')'){
                stack.Pop();
                i++;
            }
            else if( c == ' '){
                i++;
            }
            //else are number, calculate the res with the sign and add to res
            else{
                int num = 0;
                //get the number
                while(i < s.Length && Char.IsDigit(s[i])){
                    num = num * 10 + s[i] - '0';
                    i++;
                }

                res += num * sign * stack.Peek();
            }
           

        }
         return res;
    }
}

