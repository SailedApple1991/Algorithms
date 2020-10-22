/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    //memo array + dfs
    Integer[][] memo;
    public int change(int amount, int[] coins) {
        if(amount == 0 && coins.length == 0) return 1;
        if(coins.length == 0) return 0;
        Arrays.sort(coins);
        memo = new Integer[amount + 1][coins.length];
        return dfs(coins, amount, 0);
    }

    private int dfs(int[] coins, int amount, int index){
        if(amount == 0) return 1;

        if(memo[amount][index] != null) return memo[amount][index];
        int res = 0;
        for(int i = index; i < coins.length; i++){
            int coin = coins[i];
            if(amount - coin >= 0){
                res += dfs(coins, amount - coin, i);
            }
            else{
                break;
            }
        }
        memo[amount][index] = res;
        return res;
    }

}
// @lc code=end

