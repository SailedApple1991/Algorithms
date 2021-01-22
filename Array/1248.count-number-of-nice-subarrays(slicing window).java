/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 *
 * https://leetcode.com/problems/count-number-of-nice-subarrays/description/
 *
 * algorithms
 * Medium (56.57%)
 * Likes:    703
 * Dislikes: 19
 * Total Accepted:    26K
 * Total Submissions: 46.1K
 * Testcase Example:  '[1,1,2,1,1]\n3'
 *
 * Given an array of integers nums and an integer k. A continuous subarray is
 * called nice if there are k odd numbers on it.
 * 
 * Return the number of nice sub-arrays.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and
 * [1,2,1,1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {
    //slicing window https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/java-hua-dong-chuang-kou-xiang-jie-zhi-xing-yong-s/#comment
    public int numberOfSubarrays(int[] nums, int k) {
        int[] arr = new int[nums.length + 2];
        int res = 0, feed = 0;
        for(int i  = 0; i < nums.length; i++){
            // if nums[i] is odd, feed represent index to number of odds points to real index
            if((nums[i] & 1) == 1){
                arr[++feed] = i;
            }

        }
        //left 
        arr[0] = -1;
        //right
        arr[feed + 1] = nums.length;

        for(int i = 1; i + k < feed + 2; i++){
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }

        return res;
        
    }
}
// @lc code=end

