/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 *
 * https://leetcode.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (52.81%)
 * Likes:    2840
 * Dislikes: 73
 * Total Accepted:    108.6K
 * Total Submissions: 205.7K
 * Testcase Example:  '[3,1,5,8]'
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons. If the you burst balloon i you will get nums[left] * nums[i] *
 * nums[right] coins. Here left and right are adjacent indices of i. After the
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * 
 * 
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
 * not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * Example:
 * 
 * 
 * Input: [3,1,5,8]
 * Output: 167 
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  -->
 * []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 */

// @lc code=start
class Solution {
    //memo + recursion
    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        int[] copy = new int[nums.length + 2];
        copy[0] = 1;
        copy[nums.length + 1] = 1;
        for(int i = 0; i < nums.length; i++){
            copy[i + 1] = nums[i];
        }
        Integer[][] memo = new Integer[nums.length +2][nums.length + 2];
        return helper(copy,1 , nums.length, memo);

    }

    private int helper(int[] copy, int left, int right, Integer[][] memo){
        if(left > right) return 0;
        if(memo[left][right] != null) return memo[left][right]; 
        int res = 0; 

        for(int i = left; i <= right; i++){
            int tmp = helper(copy, left, i - 1, memo) + helper(copy, i + 1, right, memo) + copy[left - 1] * copy[i] * copy[right + 1];
            res = Math.max(tmp, res);
            memo[left][right] = res;
        }

        return res;
    }

}
// @lc code=end

