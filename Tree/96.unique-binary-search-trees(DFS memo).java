/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (49.33%)
 * Likes:    3887
 * Dislikes: 137
 * Total Accepted:    327.3K
 * Total Submissions: 611.3K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 19
 * 
 * 
 */

// @lc code=start
class Solution {
    //recursion
    //left node: 1 -> i - 1
    //right node: i + 1 -> n  --- n - i
    //memo utilization
    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int numTrees(int n) {

        if(n == -1) return 0;
        if(n == 0 || n == 1){
            return 1;
        }
        int sums = 0;
        for(int i = 1; i <= n; i++){
            int sum1 = 0, sum2 = 0;
            if(cache.containsKey(i - 1)){
                sum1 = cache.get(i - 1);
            }
            else{
                sum1 = numTrees(i - 1);
                cache.put(i - 1, sum1);
            }
            if(cache.containsKey(n - i)){
                sum2 =cache.get(n - i);
            }
            else{
                sum2 = numTrees(n - i);
                cache.put(n - i, sum2);
            }
            sums += sum1 * sum2;
        }
        return sums;
    }
}
// @lc code=end

