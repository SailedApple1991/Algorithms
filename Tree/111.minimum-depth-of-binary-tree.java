/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = dfs(root);
        return depth;
    }

    private int dfs(TreeNode root) {
        //if reach leaf child node, return 1
        if(root.left == null && root.right == null) return 1;
        //if root left == null, only consider right child
        else if(root.left == null){
            return dfs(root.right) + 1;
        }
        //if root right == null, only consider left child
        else if(root.right == null){
            return dfs(root.left) + 1;
        }
        
        //if both child not null
        else{
            return Math.min(dfs(root.left) + 1, dfs(root.right) + 1);
        }
    }
}
// @lc code=end

