/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */
import java.util.Arrays; 
import java.util.Collections;
// @lc code=start
class Solution {
    int picks = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        //dfs+edge cut
        Arrays.sort(coins); 
        dfs(coins, coins.length - 1, 0, amount);
        return picks == Integer.MAX_VALUE ? -1 : picks;
    }

    private void dfs(int[] coins, int index, int count, int amount){
        //exit condition 1
        if (amount == 0)  {
            picks = Math.min(picks, count);
            return;
        }

        //exit condition 2
        if(index < 0){
            return;
        }
        int coin = coins[index];
        //exit condition;
        if(index == 0){
            if(amount % coin == 0){
                picks = Math.min(picks, count + amount / coin);
            }
        }
        else{
            //use the largest as much as possible
            //edge cut while recursion
            for(int k = amount / coin; k >= 0 && k + count < picks; k--){
                dfs(coins, index - 1, count + k, amount - k * coin);

            }
        }
    }
}
// @lc code=end

