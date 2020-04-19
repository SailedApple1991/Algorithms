/*
 * @lc app=leetcode id=156 lang=csharp
 *
 * [156] Binary Tree Upside Down
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

//recursion
/*
那么我们先来看看递归的解法。对于一个根节点来说，我们的目标是将其左子节点变为根节点，
右子节点变为左子节点，原根节点变为右子节点，那么我们首先判断这个根节点是否存在，且其
有没有左子节点，如果不满足这两个条件的话，直接返回即可，不需要翻转操作。那么我们不停
的对左子节点调用递归函数，直到到达最左子节点开始翻转，翻转好最左子节点后，开始回到上
一个左子节点继续翻转即可，直至翻转完整棵树 */
public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode left = root.left, right = root.right;
        TreeNode res = UpsideDownBinaryTree(left);
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;

        return res;
    }
}

