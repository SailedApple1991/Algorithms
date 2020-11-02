/*
 * @lc app=leetcode id=375 lang=java
 *
 * [375] Guess Number Higher or Lower II
 */

// @lc code=start

import java.util.*;

class Solution {
    //memo + recursion + minmax
    public int getMoneyAmount(int n) {
        if(n < 2){
            return 0;
        }

        return helper(1, n, new HashMap<String, Integer>());
    }

    private int helper(int left, int right, Map<String, Integer> map){
        if(left >= right){
            return 0;
        }

        if(right - left == 1) return left;
        if(right - left == 2) return left + 1;
        String key = String.valueOf(left) + "+" + String.valueOf(right);
        if(map.containsKey(key)){
            return map.get(key);
        }
        int  res = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++){
            //对于 1 到 n（n > 1） 的数，我们先猜一次，最坏的情况是猜错。 因此需要比较猜错的两种情况（猜大了，猜小了）中最坏的情况的最小值。
            //如果猜小了， 范围缩小到 [i + 1, n]
            //否则缩小到 [1, i - 1]
            //在一次猜的过程中,在猜错的前提下,从左边的代价和右边的代价选一个最大的
            //因为我们要保证我们以i为开始的一轮猜数是必胜的!
            int temp=Math.max(helper(left,i-1, map),helper(i+1,right, map))+i;
            res=Math.min(res, temp); 
            map.put(key, res);
        }
        return res;
    }
}
// @lc code=end

    