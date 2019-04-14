/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 *
 * algorithms
 * Medium (52.17%)
 * Total Accepted:    7.7K
 * Total Submissions: 14.7K
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
 * 
 */
class Solution {
    public int longestOnes(int[] A, int K) {
       if(A.length == 0 || A == null) return 0;
       int left = 0, right = 0, zero =0, ans = 0;
        while(right < A.length){
            int end = A[right];
            zero += end == 0 ? 1: 0;
            //judge the start point
            while(zero > K){
                if(A[left] == 0) zero--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}

