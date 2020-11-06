/*
 * @lc app=leetcode id=1547 lang=java
 *
 * [1547] Minimum Cost to Cut a Stick
 *
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
 *
 * algorithms
 * Hard (50.81%)
 * Likes:    289
 * Dislikes: 6
 * Total Accepted:    7.8K
 * Total Submissions: 15.3K
 * Testcase Example:  '7\n[1,3,4,5]'
 *
 * Given a wooden stick of length n units. The stick is labelled from 0 to n.
 * For example, a stick of length 6 is labelled as follows:
 * 
 * Given an integer array cuts where cuts[i] denotes a position you should
 * perform a cut at.
 * 
 * You should perform the cuts in order, you can change the order of the cuts
 * as you wish.
 * 
 * The cost of one cut is the length of the stick to be cut, the total cost is
 * the sum of costs of all cuts. When you cut a stick, it will be split into
 * two smaller sticks (i.e. the sum of their lengths is the length of the stick
 * before the cut). Please refer to the first example for a better
 * explanation.
 * 
 * Return the minimum total cost of the cuts.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 7, cuts = [1,3,4,5]
 * Output: 16
 * Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the
 * following scenario:
 * 
 * The first cut is done to a rod of length 7 so the cost is 7. The second cut
 * is done to a rod of length 6 (i.e. the second part of the first cut), the
 * third is done to a rod of length 4 and the last cut is to a rod of length 3.
 * The total cost is 7 + 6 + 4 + 3 = 20.
 * Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario
 * with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).
 * 
 * Example 2:
 * 
 * 
 * Input: n = 9, cuts = [5,6,1,4,2]
 * Output: 22
 * Explanation: If you try the given cuts ordering the cost will be 25.
 * There are much ordering with total cost <= 25, for example, the order [4, 6,
 * 5, 2, 1] has total cost = 22 which is the minimum possible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= n <= 10^6
 * 1 <= cuts.length <= min(n - 1, 100)
 * 1 <= cuts[i] <= n - 1
 * All the integers in cuts array are distinct.
 * 
 */

// @lc code=start
class Solution {
    //memo + recursion
    public int minCost(int n, int[] cuts) {
        //cuts need to be sorted
        if(cuts.length == 0) return 0;
        Arrays.sort(cuts);
        // include head and tail (init border of the recursion)
        int[] points = new int[cuts.length + 2];
        points[0] = 0;
        points[points.length - 1] =  n;
        for(int i = 0; i < cuts.length; i++){
            points[i + 1] = cuts[i];
        }
        Integer[][] memo = new Integer[cuts.length + 2][cuts.length + 2];
        return helper(points, 0, points.length - 1, memo);
        
    }

    private int helper(int[] cuts, int left, int right, Integer[][] memo){

        if(memo[left][right] != null) return memo[left][right];

        int leftnum = cuts[left];
        int rightnum = cuts[right];

        if(rightnum - leftnum <= 1) return 0;  
        int min = Integer.MAX_VALUE;
        //head and tail no need to be cut off
        for(int i  = left + 1; i < right; i++){
            int tmp = helper(cuts, left, i, memo) +  helper(cuts, i, right, memo);
            min = Math.min(min, tmp);
        }
        if(min == Integer.MAX_VALUE) min = 0;
        //min cost + current cost
        else min += (rightnum - leftnum);
        memo[left][right] = min;

        return min;
    }
}
// @lc code=end

