/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        //DP with prefix sum
        //Time: O(n) Space O(n)
        int size = height.length, res = 0;
        int[] leftMax = new int[size], rightMax = new int[size];
        //pre-calculate leftMax Sum
        for(int i = 0; i < size; i++){
            leftMax[i] = i == 0 ? height[i]: Math.max(height[i], leftMax[i - 1]);
        }
        for(int i = size - 1; i >= 0; i--){
            rightMax[i] = i == size - 1 ? height[size - 1] : Math.max(height[i], rightMax[i + 1]);
        }

        for(int i = 0; i < size; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
// @lc code=end

