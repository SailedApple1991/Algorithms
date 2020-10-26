/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    //dfs + memo
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S, new HashMap());
    }

    private int dfs(int[] nums, int from, int sum, HashMap<Integer, Map<Integer, Integer>> map) {
        if(from == nums.length){
            if(sum == 0) return 1;
            else return 0;
        }

        Map<Integer, Integer> sumMap = map.get(from);

        if(sumMap != null){
            if(sumMap.containsKey(sum)){
                return sumMap.get(sum);
            }
        }
        else{
            sumMap = new HashMap<>();
            map.put(from, sumMap);
        }

        int count = dfs(nums, from + 1, sum - nums[from], map) + dfs(nums, from + 1, sum + nums[from], map);
        sumMap.put(sum, count);

        return count;

    }
}
// @lc code=end

