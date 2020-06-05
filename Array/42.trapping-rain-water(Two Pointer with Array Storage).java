/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        /*
            Two Pointers:
                left, right track two sides
                while l < r:    
                    if max_l < max_r    move left short cut side
                        ans += max_l - h[l]
                        max_l = max(max_l, h[l++])
                    else:
                        ans += max_r - h[r]
                        max_r = max(max_r, h[r--])
            Time: O(n), space O(1)
        */
        int size = height.length, res = 0;
        if(size == 0) return 0;
        int leftMax = height[0], rightMax = height[size - 1], left = 0, right = size - 1;
        while(left < right){
            if(leftMax < rightMax){
                res += leftMax - height[left];
                leftMax = Math.max(leftMax, height[++left]);
            }
            else{
                res += rightMax - height[right];
                rightMax = Math.max(rightMax, height[--right]);
            }
        }
        return res;
    }
}
// @lc code=end

