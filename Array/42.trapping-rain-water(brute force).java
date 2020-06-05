/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        /*Brute Force
            for column i, the rain it can trap:
            r[i] = min(max(h[0~i]),
                       max(h[i~n-1])) - h[i]
            ans = sum(r[i])
            time: O(n^2) space: O(1)
        */
        int res = 0 , size = height.length;
        for( int i = 0; i < size; i++){
            int leftMax = getMaxHeight(0, i+1, height);
            int rightMax = getMaxHeight(i, size, height);
            res += Math.min(leftMax, rightMax) - height[i];
        }

        return res;

    }

    private int getMaxHeight(int start, int end, int[] height){
        int maxHeight = 0;
        while(start < end){
            maxHeight = Math.max(maxHeight, height[start++]);
        }
        return maxHeight;
    }
}
// @lc code=end

