/*
 * @lc app=leetcode id=235 lang=csharp
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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
 //Traverse time complexity : O(n)
 //Three case: 1. two points greater than root ---> root.right
//             2. two points less than root ---> root.left
//             3. lowest ancester is root
public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode node = root;
        //loop traverse
        while(node != null){
        //case 1 : greater
        if(p.val > node.val && q.val > node.val){
            node = node.right;
        }
        //case 2 : less
        if(p.val < node.val && q.val < node.val){
            node = node.left;
        }
        //find the node
        else{
            return node;
        }


        }
    return node;
    }
}

