import java.util.Arrays;

/*
 * @lc app=leetcode id=1494 lang=java
 *
 * [1494] Parallel Courses II
 *
 * https://leetcode.com/problems/parallel-courses-ii/description/
 *
 * algorithms
 * Hard (30.90%)
 * Likes:    269
 * Dislikes: 27
 * Total Accepted:    5.2K
 * Total Submissions: 16.8K
 * Testcase Example:  '4\n[[2,1],[3,1],[1,4]]\n2'
 *
 * Given the integer n representing the number of courses at some university
 * labeled from 1 to n, and the array dependencies where dependencies[i] = [xi,
 * yi]  represents a prerequisite relationship, that is, the course xi must be
 * taken before the course yi.  Also, you are given the integer k.
 * 
 * In one semester you can take at most k courses as long as you have taken all
 * the prerequisites for the courses you are taking.
 * 
 * Return the minimum number of semesters to take all courses. It is guaranteed
 * that you can take all courses in some way.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2
 * Output: 3 
 * Explanation: The figure above represents the given graph. In this case we
 * can take courses 2 and 3 in the first semester, then take course 1 in the
 * second semester and finally take course 4 in the third semester.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: n = 5, dependencies = [[2,1],[3,1],[4,1],[1,5]], k = 2
 * Output: 4 
 * Explanation: The figure above represents the given graph. In this case one
 * optimal way to take all courses is: take courses 2 and 3 in the first
 * semester and take course 4 in the second semester, then take course 1 in the
 * third semester and finally take course 5 in the fourth semester.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 11, dependencies = [], k = 2
 * Output: 6
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 15
 * 1 <= k <= n
 * 0 <= dependencies.length <= n * (n-1) / 2
 * dependencies[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * All prerequisite relationships are distinct, that is, dependencies[i] !=
 * dependencies[j].
 * The given graph is a directed acyclic graph.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        //refered dp solution
        int[] dp = new int[1<<n];
        int[] preCourse = new int[n];
        int[] preReq = new int[1<<n];
        Arrays.fill(dp, Integer.MAX_VALUE /2);

        for(int[] x : dependencies){
            //zipping states
            preCourse[x[1] - 1] += 1 << (x[0] - 1);
        }

        for(int state = 0; state <(1<<n); state++){
            preReq[state] = 0;
            for(int i = 0; i < n; i++){
                if(((state >> i) &1) > 0){
                    preReq[state] |= preCourse[i];
                }
            }
        }
        dp[0] = 0;
        for(int state = 0; state <(1<<n); state++){
            for(int subset = state; subset >= 0; subset = (subset - 1) & state){
                if(Integer.bitCount(state) - Integer.bitCount(subset) <= k  && (subset & preReq[state]) == preReq[state]){
                    dp[state] = Math.min(dp[state], dp[subset] + 1);
                }

                if(subset == 0) break;
            }
        }

        return dp[(1<<n) - 1];
    }

}
// @lc code=end

