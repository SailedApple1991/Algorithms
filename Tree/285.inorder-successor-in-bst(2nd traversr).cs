/*
 * @lc app=leetcode id=285 lang=csharp
 *
 * [285] Inorder Successor in BST
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
 //traverse revision
public class Solution {
    public TreeNode InorderSuccessor(TreeNode root, TreeNode p) {
        //left mid right
        if(root == null || p == null){
            return null;
        }
        TreeNode successor = null;
        while(root != null && root.val != p.val){
            if(root.val > p.val){
                successor = root;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        //if p is not found
        if(root == null) return null;
        //if p is found and right is null, then we need to find the successor which was recorded as the last element which larger than root
        if(root.right == null){
            return successor;
        }
        //if p is found and right is not null, we need to find this successor in the least element (left most element) in the right sub tree
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}

