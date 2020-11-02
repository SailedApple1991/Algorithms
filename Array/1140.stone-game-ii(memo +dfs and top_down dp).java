/*
 * @lc app=leetcode id=1140 lang=java
 *
 * [1140] Stone Game II
 *
 * https://leetcode.com/problems/stone-game-ii/description/
 *
 * algorithms
 * Medium (61.80%)
 * Likes:    601
 * Dislikes: 147
 * Total Accepted:    20.4K
 * Total Submissions: 31.4K
 * Testcase Example:  '[2,7,9,4,4]'
 *
 * Alex and Lee continue their games with piles of stones.  There are a number
 * of piles arranged in a row, and each pile has a positive integer number of
 * stones piles[i].  The objective of the game is to end with the most
 * stones. 
 * 
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 * 
 * On each player's turn, that player can take all the stones in the first X
 * remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * 
 * The game continues until all the stones have been taken.
 * 
 * Assuming Alex and Lee play optimally, return the maximum number of stones
 * Alex can get.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alex takes one pile at the beginning, Lee takes two piles,
 * then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total.
 * If Alex takes two piles at the beginning, then Lee can take all three piles
 * left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since
 * it's larger. 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 * 
 * 
 */

// @lc code=start
class Solution {
    //memo + dfs
    // public int stoneGameII(int[] piles) {
    //     int n = piles.length;
    //     if(n == 0) return 0;
    //     int[][] cache =  new int[n][n];
    //     int[] sums = new int[n + 1];
    //     //current sum alex can have
    //     for(int i =0; i < n; i++){
    //      sums[i + 1] = sums[i] + piles[i];
    //     }

    //     return dfs(piles, 0, 1, cache, sums);
    // }

    // private int dfs(int[] piles, int cur, int m, int[][] cache, int[] sums){
    //     if(cur > piles.length -1) return 0;
    //     //if(2*m >= piles.length - cur) return sums[cur];

    //     if(cache[cur][m] != 0) return cache[cur][m];
    //     int maxVal =  0;

    //     for(int x = 1; x <= 2 * m; x++){
    //         int next_max_stones = dfs(piles, cur + x, Math.max(m, x), cache, sums);
    //         //current player max taken stones
    //         maxVal = Math.max(maxVal, sums[piles.length] - sums[cur] - next_max_stones);
    //     }
    //     cache[cur][m] = maxVal;
    //     return cache[cur][m];
    // }


    //top-down
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        if(n == 0) return 0;
        int[][] cache =  new int[n][n];
        int[] sums = new int[n];
        sums[n - 1] = piles[n - 1];
        //current sum alex can have
        for(int i = n - 2; i >= 0; i--){
         sums[i] = sums[i + 1] + piles[i];
        }

        return dfs(piles, 0, 1, cache, sums);
    }

    private int dfs(int[] piles, int cur, int m, int[][] cache, int[] sums){
        if(cur > piles.length -1) return 0;
        if(2*m >= piles.length - cur) return sums[cur];

        if(cache[cur][m] != 0) return cache[cur][m];
        int minVal =  Integer.MAX_VALUE;

        for(int x = 1; x <= 2 * m; x++){
            //next player max taken stones
            int next_max_stones = dfs(piles, cur + x, Math.max(m, x), cache, sums);
            //current player max taken stones
            minVal = Math.min(minVal, next_max_stones);
        }
        cache[cur][m] = sums[cur] - minVal;
        return cache[cur][m];
    }
}
// @lc code=end

