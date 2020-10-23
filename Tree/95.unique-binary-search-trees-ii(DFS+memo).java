/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (38.23%)
 * Likes:    2554
 * Dislikes: 174
 * Total Accepted:    207.2K
 * Total Submissions: 500.3K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
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
 * 0 <= n <= 8
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //DFS + memo edge cut
    List<TreeNode>[][] memo;
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        memo = new ArrayList[n + 1][n + 1];
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right){
        List<TreeNode> res = new ArrayList<TreeNode>();
        //exit condition
        if(left > right){
            res.add(null);
            return res;
        }
        if(memo[left][right]!= null) return memo[left][right];
        
        //iterate from left to right node as root node
        for(int i = left; i <= right; i++){
            //gain all permutations for left
            List<TreeNode> leftTree = dfs(left, i - 1);
            //gain all permutations for right
            List<TreeNode> rightTree = dfs(i + 1, right);
            //iterate left tree
            for(TreeNode leftNode : leftTree){
                //iterate right tree
                for(TreeNode rightNode : rightTree){
                    //generate current Node
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftNode;
                    cur.right = rightNode;
                    res.add(cur);
                }
            }
        }
        memo[left][right] = res;
        return res;
    }

}
// @lc code=end

