/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (38.85%)
 * Likes:    3197
 * Dislikes: 130
 * Total Accepted:    321.5K
 * Total Submissions: 821.8K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 */

// @lc code=start
class Solution {
    //brute force
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= s){
                    res = Math.min(res, j - i + 1);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end

