import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteDFS(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }

    private void permuteDFS(int[] nums, boolean[] visited, List<Integer> out, List<List<Integer>> res){
        if(out.size() == nums.length){
            res.add(new ArrayList<>(out));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out.add(nums[i]);
                permuteDFS(nums, visited, out, res);
                out.remove(out.size() - 1);
                visited[i] = false;
            }

    }

    }
}
// @lc code=end

