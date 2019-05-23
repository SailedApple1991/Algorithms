/*
 * @lc app=leetcode id=236 lang=csharp
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
 //DFS Time Complexity: O(n) space: O(n)
 // two case: 1. node is p or q
//            2. node is ancester
public class Solution {
    private TreeNode ans;
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        dfs(root, p, q);
        return ans;
    } 

    bool dfs(TreeNode root, TreeNode p, TreeNode q){
        //base case
        if(root == null) return false;
        int mid = (root == q || root == p) ? 1 : 0;
        int left = dfs(root.left, p, q) ? 1 : 0;
        int right = dfs(root.right, p, q) ? 1 : 0;
       
        //if condition met, found the ancestor and update the ans
        if(left + right + mid >= 2) this.ans = root;

        return (left + right + mid) > 0;
    }

}

