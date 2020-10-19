/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
     /*
       1. Every recursion there are two options: 1) take the cur value --> helper(cursum + nums[i], i + 1)  ||    2) no take the cur value --> helper(curSum, i + 1)
       2. Termination conditions: 3---> 1) ptr out of range, all of eles checked return false  || 2) cursum > target return false    || curSum return true
    */
    HashMap<String, Boolean> memo = new HashMap<String, Boolean>();
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        //get sum of arr
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        
        //memo
        return canPartitionHelper(nums, target, 0, 0);
    }
    
    private boolean canPartitionHelper(int[] nums, int target, int curSum, int level){
        String curKey = curSum + "&" + level;
        //if exist, return;
        if(memo.containsKey(curKey)){
            return memo.get(curKey);
        }
        //exit conditions
        if(level > nums.length - 1|| curSum > target){
            return false;
        }
        if(curSum == target){
            return true;
        }
        
        boolean res = canPartitionHelper(nums, target, curSum + nums[level], level + 1) || canPartitionHelper(nums, target, curSum, level + 1);
        memo.put(curKey, res);
        
        return res;
    }
}
// @lc code=end

