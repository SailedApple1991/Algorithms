/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        int maxProduct = 1, zeroCount = 0, zeroFirstIndex = -1;
        for(int i = 0; i < size; i++){  
            if(nums[i] == 0){
                zeroCount ++;
                if(zeroCount == 1){
                    zeroFirstIndex = i;
                }
                continue;
            }
               maxProduct *= nums[i];
        }
        if(zeroCount > 1){
            return res;
        }
        else if(zeroCount == 1){
            res[zeroFirstIndex] = maxProduct;
            return res;
        }
        for(int i = 0 ; i < size; i++){
            res[i] = maxProduct / nums[i];
        }

        return res;
    }
}
// @lc code=end

