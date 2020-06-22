import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        // 00
        // 01
        // 10
        // 11

        // 100
        // 101
        // 110
        // 111
        //  1 << 4 1 -> 8 2 -> 7 3 -> 6
        // time O(n^2), space O(1)
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int  i = 0; i < n; i++){
            int add = 1 << i;

            for(int j = res.size() - 1; j >= 0; j--){
                res.add(res.get(j) + add);
            }
        }
        return res;

    }
}
// @lc code=end

