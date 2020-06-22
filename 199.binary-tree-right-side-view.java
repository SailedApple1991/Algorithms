import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    HashMap<Integer, List<Integer>> ans = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        //preorder recursion
        preTravesal(root, 0);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: ans.entrySet()){

            res.add(entry.getValue().get(entry.getValue().size() - 1));
        }
        return res;
    }

    public void preTravesal(TreeNode root, int depth){
        if(root == null) return;
        if(!ans.containsKey(depth)){
            List<Integer> tmp = new ArrayList<>();
            ans.put(depth, tmp);
        }
        ans.get(depth).add(root.val);
        preTravesal(root.left, depth + 1);
        preTravesal(root.right, depth + 1);
    }
}
// @lc code=end

