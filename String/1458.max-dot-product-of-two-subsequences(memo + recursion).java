/*
 * @lc app=leetcode id=1458 lang=java
 *
 * [1458] Max Dot Product of Two Subsequences
 *
 * https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/
 *
 * algorithms
 * Hard (42.48%)
 * Likes:    364
 * Dislikes: 9
 * Total Accepted:    11.3K
 * Total Submissions: 26.5K
 * Testcase Example:  '[2,1,-2,5]\r\n[3,0,-6]\r'
 *
 * Given two arrays nums1 and nums2.
 * 
 * Return the maximum dot product between non-empty subsequences of nums1 and
 * nums2 with the same length.
 * 
 * A subsequence of a array is a new array which is formed from the original
 * array by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, [2,3,5] is a
 * subsequence of [1,2,3,4,5] while [1,5,3] is not).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * Output: 18
 * Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from
 * nums2.
 * Their dot product is (2*3 + (-2)*(-6)) = 18.
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [3,-2], nums2 = [2,-6,7]
 * Output: 21
 * Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
 * Their dot product is (3*7) = 21.
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [-1,-1], nums2 = [1,1]
 * Output: -1
 * Explanation: Take subsequence [-1] from nums1 and subsequence [1] from
 * nums2.
 * Their dot product is -1.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        /*
            1) max = max(max, nums1[i] * nums2[j])
            2) max = max(max, nums1[i] * nums[j] + helper(i + 1, j + 1))
            3) max = max(max, helper(i + 1, j + 1))
            4）max = max(max, helper(i, j + 1))
            5) max = max(max, helper(i + 1, j))
        */
        if(nums1.length == 0 || nums2.length == 0) return 0;
        Integer[][] memo = new Integer[nums1.length][nums2.length];
        return helper(nums1, nums2, 0, 0, memo);
    }

    private int helper(int[] nums1, int[] nums2, int i, int j, Integer[][] memo){
        if(i >= nums1.length || j >= nums2.length) return 0;
        if(memo[i][j] != null) return memo[i][j];
        //1)
        int max = nums1[i] * nums2[j];
        if(i + 1 < nums1.length && j + 1 < nums2.length){
            int next = helper(nums1, nums2, i + 1, j + 1, memo);
            //2)
            max = Math.max(max, max + next);
            //3)
            max = Math.max(max, next);
        }
        if(j + 1 < nums2.length){
            //4)
            max = Math.max(max, helper(nums1, nums2, i, j + 1, memo));
        }
        if(i + 1 < nums1.length){
            //5)
            max = Math.max(max, helper(nums1, nums2, i + 1, j, memo));
        }
        

        memo[i][j] = max;

        return max;
    }
}
// @lc code=end

