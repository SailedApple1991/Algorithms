import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length) return null;
        //use PQ 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> a2 -a1);
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            //optimize the get max operiration to O(1)
            //PQ's offer O(logk), remove O(N)
            //remove when size = k
            // still O(nk)
            //we need to use treemap
            if(pq.size() == k){
                pq.remove(nums[i - k]);
            }
            pq.offer(nums[i]);
            if(i >= k -1){
                res[index++] = pq.peek();
            }
        }
        return res;
    }
}
// @lc code=end

