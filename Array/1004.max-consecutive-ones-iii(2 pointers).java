/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 *
 * algorithms
 * Medium (60.06%)
 * Likes:    1749
 * Dislikes: 29
 * Total Accepted:    82.4K
 * Total Submissions: 136.3K
 * Testcase Example:  '[1,1,1,0,0,0,1,1,1,1,0]\n2'
 *
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * 
 * Return the length of the longest (contiguous) subarray that contains only
 * 1s. 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation: 
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is
 * underlined.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation: 
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is
 * underlined.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] is 0 or 1 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    //same-way two pointers
    //Time: O(n)
    //space: O(1)
    public int longestOnes(int[] A, int K) {
        int left = 0, ans  = 0,zeros = 0;
        for(int right = 0; right < A.length; right++){
            if(A[right] == 0){
                zeros++;
            }
            while(zeros > K){
                //check left val
                if(A[left] == 0){
                    zeros--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end

