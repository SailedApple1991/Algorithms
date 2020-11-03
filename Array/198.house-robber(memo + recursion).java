/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (41.76%)
 * Likes:    5931
 * Dislikes: 172
 * Total Accepted:    621.4K
 * Total Submissions: 1.5M
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
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house
 * 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        Integer[] memo = new Integer[nums.length + 1];
        return robMax(nums, 0, memo);
    }

    private int robMax(int[] nums, int index, Integer[] memo){
        if(index > nums.length){
            return 0;
        }
        if(memo[index] != null){
            return memo[index];
        }
        int res = 0;
        for(int i = index; i < nums.length; i++){//根节点对应的各个分支，能偷取的最大值，选分支中最大的
            res = Math.max(res, nums[i] + robMax(nums, i + 2, memo));
        }
        memo[index] = res;
        return res;
    }
}
// @lc code=end

