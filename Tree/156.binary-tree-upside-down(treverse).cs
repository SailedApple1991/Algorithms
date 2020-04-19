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
public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root, pre = null, next = null, tmp = null;
        while(cur != null){
            next = cur.left;
            cur.left = tmp;
            tmp = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

