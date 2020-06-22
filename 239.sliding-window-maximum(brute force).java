/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length) return null;
        //brute force   ----  O(nk)
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < res.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < k; j++){
                max = max > nums[i + j] ? max : nums[i + j];
            }
            res[i] = max; 
        }
     return res;   
    }
}
// @lc code=end

