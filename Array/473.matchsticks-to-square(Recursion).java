/*
 * @lc app=leetcode id=473 lang=java
 *
 * [473] Matchsticks to Square
 */

// @lc code=start
class Solution {
    //Recursion + edge cut
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4) return false;
        int sum = Arrays.stream(nums).sum();
        if(sum % 4 != 0) return false;
        Integer[] nums_p = Arrays.stream(nums).boxed().toArray( Integer[] :: new);
        Arrays.sort(nums_p, Collections.reverseOrder());
        int[] sums = new int[4];
        return helper(nums_p, sums, 0, sum / 4);

    }

    private boolean helper(Integer[] nums, int[] sums, int pos, int target) {
        //exit condition
        if(pos >= nums.length){
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }

        for(int i = 0; i < 4; i++){
            if(sums[i] + nums[pos] > target) continue;
            sums[i] += nums[pos];
            if(helper(nums, sums, pos + 1, target)) return true;
            sums[i] -= nums[pos];
        }

        return false;
    }
}
// @lc code=end

