import java.util.TreeMap;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Use TreeMap red black tree O(nlogk)
        if(nums == null || nums.length == 0 || k > nums.length) return null;
        TreeMap<Integer, Integer> tree = new TreeMap<>((q1, q2) -> q2 - q1);
        int[] res = new int[nums.length - k + 1];
        int count  = 0;
        for(int i = 0; i < nums.length; i++){
            //need to judge if treemap contains same element and maybe multiple
            //when i >=k need to remove an element --logk
            //cannot directly judge with size of treemap and k --- nums may has duplicate value records
            if(i >= k){
                Integer v = tree.get(nums[i - k]);
                //contains
                if(v == 1){
                    tree.remove(nums[i - k]);
                }
                else{
                    tree.put(nums[i - k], v - 1);
                }
            }
            //add element 
            Integer v = tree.get(nums[i]);
            if(v == null){
                tree.put(nums[i], 1);
            }
            else{
                tree.put(nums[i], v + 1);
            }

            //add to res
            if(i >= k - 1){
                res[count++] = tree.firstKey();
            }
        }
        return res;
    }
}
// @lc code=end

