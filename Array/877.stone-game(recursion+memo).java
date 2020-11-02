/*
 * @lc app=leetcode id=877 lang=java
 *
 * [877] Stone Game
 *
 * https://leetcode.com/problems/stone-game/description/
 *
 * algorithms
 * Medium (64.01%)
 * Likes:    881
 * Dislikes: 1154
 * Total Accepted:    70.3K
 * Total Submissions: 106.6K
 * Testcase Example:  '[5,3,4,5]'
 *
 * Alex and Lee play a game with piles of stones.  There are an even number of
 * piles arranged in a row, and each pile has a positive integer number of
 * stones piles[i].
 * 
 * The objective of the game is to end with the most stones.  The total number
 * of stones is odd, so there are no ties.
 * 
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player
 * takes the entire pile of stones from either the beginning or the end of the
 * row.  This continues until there are no more piles left, at which point the
 * person with the most stones wins.
 * 
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins
 * the game.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: piles = [5,3,4,5]
 * Output: true
 * Explanation: 
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10
 * points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win
 * with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we
 * return true.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= piles.length <= 500
 * piles.length is even.
 * 1 <= piles[i] <= 500
 * sum(piles) is odd.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] cache = new int[n][n];
        return score(piles, 0, n - 1, cache) > 0;
    }
    private int score(int[] piles, int left, int right, int[][] cache){
        if(left == right) return piles[left];
        //score for alex more than lee
        if(cache[left][right] == 0){
            cache[left][right] = Math.max(piles[left] - score(piles, left + 1, right, cache), 
            piles[right] - score(piles, left, right - 1, cache));
        }

        return cache[left][right];
    }
}
// @lc code=end

