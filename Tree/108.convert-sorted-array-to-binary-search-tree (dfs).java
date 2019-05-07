/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//dfs
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        return dfs(nums, 0, nums.length - 1); 
    }
    private TreeNode dfs(int[] nums, int left, int right){
        if(left > right) return null;
         //mid point as start point
         TreeNode start = new TreeNode(nums[(left + right) / 2]);
         start.left = dfs(nums, left, (left + right) /  2 - 1);
         start.right = dfs(nums, (left + right) / 2 + 1, right);
         return start;
    }
}

