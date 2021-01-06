/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 *
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 *
 * algorithms
 * Medium (40.67%)
 * Likes:    367
 * Dislikes: 21
 * Total Accepted:    16.4K
 * Total Submissions: 39.8K
 * Testcase Example:  '[1,0,1,0,1]\n2'
 *
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation: 
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numSubarraysWithSum(int[] A, int S) {
        int prefix = 0, 
        res = 0;
        map.put(0, 1);

        for(int i = 0; i < A.length; i++){
            prefix += A[i];
            if(map.containsKey(prefix - S)){
               res += map.get(prefix - S);
            }
            if(map.getOrDefault(prefix, 0) != 0){
                map.put(prefix, map.get(prefix)+ 1);
            }else{
                map.put(prefix, 1);
            }
        }
        return res;
    }
}
// @lc code=end

