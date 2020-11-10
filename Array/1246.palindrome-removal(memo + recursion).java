/*
 * @lc app=leetcode id=1246 lang=java
 *
 * [1246] Palindrome Removal
 *
 * https://leetcode.com/problems/palindrome-removal/description/
 *
 * algorithms
 * Hard (45.67%)
 * Likes:    191
 * Dislikes: 5
 * Total Accepted:    6.2K
 * Total Submissions: 13.5K
 * Testcase Example:  '[1,2]'
 *
 * Given an integer array arr, in one move you can select a palindromic
 * subarray arr[i], arr[i+1], ..., arr[j] where i <= j, and remove that
 * subarray from the given array. Note that after removing a subarray, the
 * elements on the left and on the right of that subarray move to fill the gap
 * left by the removal.
 * 
 * Return the minimum number of moves needed to remove all numbers from the
 * array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [1,2]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,3,4,1,5]
 * Output: 3
 * Explanation: Remove [4] then remove [1,3,1] then remove [5].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 20
 * 
 * 
 */

// @lc code=start

 /*3 case
            if (fromValue == arr[i]) 
        1. start and i near --- > helper(arr, start, end) = 1 + helper(arr, i , end)
        
        2. [1,2,3,1] delete 2  ---> 1，3，1
                            1，3，1 palindrome，delete one time
                            except for head and tail element, rest elements must form a palindrome or a single number. and this can form a palindrome with head and tail.
        start and i not near ---> helper(arr, start , end ) =  helper(arr, start + 1, i -1) + helper( arr, i + 1, end) 
        
        3. or  helper(arr, start, end) =  1 + helper(arr, start + 1, end)
        */
class Solution {
    public int minimumMoves(int[] arr) {
       int length = arr.length;
       int[][] memo = new int[length + 1][length + 1];

       return helper(arr, 0, length - 1, memo);
    }

    public int helper(int[] arr, int left, int right, int[][] memo){
        if(right < left) return 0;

        if(memo[left][right] > 0) return memo[left][right];

        int res = Integer.MAX_VALUE;

        int leftVal =  arr[left];

        for(int i = left + 1; i <= right; i++){
            if(leftVal == arr[i]){
                int tmp = 0;
                if(i -left == 1){
                    tmp = 1 + helper(arr, i + 1, right, memo);
                }
                else{
                    tmp = helper(arr, left + 1, i - 1, memo) + helper(arr, i + 1, right, memo);
                }
                res = Math.min(res, tmp);
            }
        }
        res =  Math.min(res, 1 + helper(arr, left + 1, right, memo));
        memo[left][right] = res;
        return res;
    }
}
// @lc code=end

