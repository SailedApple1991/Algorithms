/*
 * @lc app=leetcode id=1349 lang=java
 *
 * [1349] Maximum Students Taking Exam
 *
 * https://leetcode.com/problems/maximum-students-taking-exam/description/
 *
 * algorithms
 * Hard (43.12%)
 * Likes:    343
 * Dislikes: 9
 * Total Accepted:    6.5K
 * Total Submissions: 15.1K
 * Testcase Example:  '[["#",".","#","#",".","#"],[".","#","#","#","#","."],["#",".","#","#",".","#"]]'
 *
 * Given a m * n matrix seats  that represent seats distributions in a
 * classroom. If a seat is broken, it is denoted by '#' character otherwise it
 * is denoted by a '.' character.
 * 
 * Students can see the answers of those sitting next to the left, right, upper
 * left and upper right, but he cannot see the answers of the student sitting
 * directly in front or behind him. Return the maximum number of students that
 * can take the exam together without any cheating being possible..
 * 
 * Students must be placed in seats in good condition.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: seats = [["#",".","#","#",".","#"],
 * [".","#","#","#","#","."],
 * ["#",".","#","#",".","#"]]
 * Output: 4
 * Explanation: Teacher can place 4 students in available seats so they don't
 * cheat on the exam. 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: seats = [[".","#"],
 * ["#","#"],
 * ["#","."],
 * ["#","#"],
 * [".","#"]]
 * Output: 3
 * Explanation: Place all students in available seats. 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: seats = [["#",".",".",".","#"],
 * [".","#",".","#","."],
 * [".",".","#",".","."],
 * [".","#",".","#","."],
 * ["#",".",".",".","#"]]
 * Output: 10
 * Explanation: Place students in available seats in column 1, 3 and 5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * seats contains only characters '.' and'#'.
 * m == seats.length
 * n == seats[i].length
 * 1 <= m <= 8
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start
class Solution {
    //recursion
    //memo[][] row + state
    public int maxStudents(char[][] seats) {
        int state = 1;
        //get maximum value of state, which every column has seat
        for(int c = 0; c < seats[0].length; c++){
            state = ((1 << c) | state);
        }
        int[][] memo = new int[seats.length][state];
        //recursion from left top
        return help(seats, 0, 0, 0, memo);
    }

    private int help(char[][] seats, int r, int c, int rowState, int[][] memo){
        //exit 
        if(c == 0  && r > 0) {
            //first column ---- row state is the last row seat arrangement
            //check if memo has it ---- > return
            if(memo[r - 1][rowState] > 0) return memo[r - 1][rowState];
        }

        //current char
        char ch = seats[r][c];
        // calculate next recursion position
        int nextR = r, nextC = c;
        if(c+1 < seats[0].length){
            nextC = c + 1;
        }
        else{
            nextC = 0;
            nextR = r + 1;
        }

        boolean canSit = canSitChecker(seats, r, c);
        //check if this position is the last place of the matrix -> terminate condition
        if(nextR == seats.length){
            return canSit?1:0;
        }
        //first choice - > arrange seat
        int count1 = 0;

        if(canSit){
            seats[r][c] = 's';
            count1 = 1 + help(seats, nextR, nextC, c == 0 ? 1 : ((rowState<<1) | 1), memo);
            //recursion end , return current position to origin char, for other recursion check purpose
            seats[r][c] = ch;
        }
        //second choice --> no seat for current position
        int count2 = help(seats, nextR, nextC, c == 0 ? 0 : ((rowState<<1) | 0), memo);

        //maxmimum from count 1 and count 2 is the res
        int res = Math.max(count1, count2);

        //if this is the first row
        if(c == 0 && r > 0){
            memo[r - 1][rowState] =  res;
        }

            return res;
    }

    private boolean canSitChecker(char[][] seats, int r, int c) {
        //if it is a broken seat return false
        if(seats[r][c] == '#') return false;
        //left most has seat 
        if(r > 0 && c > 0){
            if(seats[r - 1][c - 1] == 's'){
                return false;
            }
        }
        //right most
        if(r > 0 && c < seats[0].length - 1){
            if(seats[r - 1][c + 1] == 's') return false;
        }
        //left side has seat
        if(c > 0){
            if(seats[r][c - 1] == 's') return false;
        }
        //recurstion order : top - down, left - right, so right and bot don't need to be checked
        return true;

    }
}
// @lc code=end

