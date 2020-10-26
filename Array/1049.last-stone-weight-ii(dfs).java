/*
 * @lc app=leetcode id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 */

// @lc code=start
class Solution {

    //(dfs)
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones) sum += stone;
        int half = sum >> 1;
        for(int i = half; i >=0; i--){
            if(dfs(stones, 0, i, 0)) return sum - 2*i;
        }

        return 0;
    }

    private boolean dfs(int[] stones, int ind, int sum, int target){
        if(target == sum) return true;

        if(target > sum) return false;

        if(ind == stones.length) return false;

        return dfs(stones, ind + 1, sum, target + stones[ind]) || dfs(stones, ind + 1, sum, target);
    }
}
// @lc code=end

