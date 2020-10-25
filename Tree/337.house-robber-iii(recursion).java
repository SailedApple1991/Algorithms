/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return dfs(root, map);
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);

        int val = 0;
        if(root.left != null){
            val += dfs(root.left.left, map) + dfs(root.left.right, map);
        }
        if(root.right != null){
            val += dfs(root.right.left, map) + dfs(root.right.right, map);
        }

        val = Math.max(val + root.val, dfs(root.left, map) + dfs(root.right, map));

        map.put(root, val);
        return val;
    }
}
// @lc code=end

