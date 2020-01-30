/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (41.56%)
 * Likes:    3639
 * Dislikes: 116
 * Total Accepted:    426.7K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,1]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * 
 * 
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house
 * 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] memo;
    public int rob(int[] nums) {
        //DP solution
        //step one recursion relation  a) rob current house b) dont rob current house
        //rob(i) = max(rob(i - 2) + currentHouse, rob(i - 1))
        //use memo[] to reduce the recursion time
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i){
        if(i < 0){
            return 0;
        }
        if(memo[i] >= 0){
            return memo[i];
        }
        int res = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = res;
        return res;
    }
}
// @lc code=end

