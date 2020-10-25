/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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

    // there is a increasing increment array for inorder traversal into BST
    int num = 0, res = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return res;
    }

    private void inorderTraversal(TreeNode root, int k) {
        if(root == null){
            return;
        }
        inorderTraversal(root.left, k);
        num++;
        if(num == k){
            res = root.val;
        }
        inorderTraversal(root.right, k);


    }
}
// @lc code=end

