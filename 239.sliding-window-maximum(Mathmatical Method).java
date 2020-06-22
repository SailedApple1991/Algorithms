/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //mathmatic way O(n)
        if(nums == null || nums.length == 0 || nums.length < k) return null;
        int[] res = new int[nums.length - k + 1];
        int[] leftMax = new int[nums.length ];
        int[] rightMax = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0;  i < nums.length; i++){
            if( i % k == 0){
                max = Integer.MIN_VALUE;
            }
            max = max > nums[i] ? max : nums[i];
            leftMax[i] = Math.max(max, nums[i]); 
        }
        max = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--){
            max = max > nums[i] ? max : nums[i];
            
            rightMax[i] = Math.max(max, nums[i]);
            if(i % k == 0){
                max = Integer.MIN_VALUE;
            }
        }

        for(int i = 0; i < res.length; i++){
            res[i] = Math.max(leftMax[i + k - 1], rightMax[i] );
        }

        return res;
    }
}
// @lc code=end

