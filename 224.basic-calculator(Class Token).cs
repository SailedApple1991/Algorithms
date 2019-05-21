/*
 * @lc app=leetcode id=224 lang=csharp
 *
 * [224] Basic Calculator
 */
public class Solution {
    public class ExpressionTokenizer{
        string[] word;
        int count = 0;
        enum Type{
            NUMBER,     //e.g, 2, 3, 4
            OPERATOR,   // +, -
            PARENTHESIS  //(, )
        }
        public ExpressionTokenizer(string expression){
                word = expression.Split("");
        }
        public string nextToken (){

        }
        public string getType(char token){
            
        }

        public int intValue(){

        }
        public char charValue(){

        }
    }
    public int Calculate(string s) {
        
    }
}

