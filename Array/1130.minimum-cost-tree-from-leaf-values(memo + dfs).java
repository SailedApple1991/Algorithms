/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 *
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/
 *
 * algorithms
 * Medium (67.11%)
 * Likes:    1593
 * Dislikes: 123
 * Total Accepted:    41.7K
 * Total Submissions: 62.1K
 * Testcase Example:  '[6,2,4]'
 *
 * Given an array arr of positive integers, consider all binary trees such
 * that:
 * 
 * 
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order
 * traversal of the tree.  (Recall that a node is a leaf if and only if it has
 * 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf
 * value in its left and right subtree respectively.
 * 
 * 
 * Among all possible binary trees considered, return the smallest possible sum
 * of the values of each non-leaf node.  It is guaranteed this sum fits into a
 * 32-bit integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the
 * second has non-leaf node sum 32.
 * 
 * ⁠   24            24
 * ⁠  /  \          /  \
 * ⁠ 12   4        6    8
 * ⁠/  \               / \
 * 6    2             2   4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * It is guaranteed that the answer fits into a 32-bit signed integer (ie. it
 * is less than 2^31).
 * 
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int length = arr.length;
        int[][] memo = new int[length + 2][length + 2]; 
        return helper(arr,0, length - 1, memo);
    }

    private int helper(int[] arr, int left, int right, int[][] memo){
            if(right <= left) return 0;

            if(memo[left][right] > 0) return memo[left][right];

            int ans = Integer.MAX_VALUE;

            for(int i = left + 1; i < right + 1; i++){
                ans = Math.min(ans, helper(arr, left, i - 1, memo) + helper(arr, i, right, memo) + maxFinder(arr, left, i ) * maxFinder(arr, i, right + 1));
            }

            memo[left][right] = ans;
            return ans;
    }

    private int maxFinder(int[] arr, int left, int right){
        int val = Integer.MIN_VALUE;
        for(int i = left; i < right; i++){
            if(arr[i] > val){
                val = arr[i];
            }
        }
        return val;
    }

}
// @lc code=end

