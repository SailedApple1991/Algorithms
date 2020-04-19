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
 //traverse - bst tree props
public class Solution {
    public TreeNode InorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode pre = null;
            while(root != null){
                
                    
                if(root.val > p.val){
                    pre = root;
                    root = root.left;
                }
                else{
                    root = root.right;
                }

            }

            return pre;
    }
}

