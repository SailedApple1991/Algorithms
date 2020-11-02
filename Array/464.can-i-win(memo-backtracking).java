/*
 * @lc app=leetcode id=464 lang=java
 *
 * [464] Can I Win
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal){
            return false;
        }
        int[] state = new int[maxChoosableInteger + 1]; 
        return canWin(desiredTotal, state, new HashMap<String, Boolean>());
    }

    public boolean canWin(int desiredTotal, int[] state, Map<String, Boolean> map){
        String key = Arrays.toString(state);
        if(map.containsKey(key)){
            return map.get(key);
        }

        for(int i = 1; i < state.length; i++){
            if(state[i] == 0){
                state[i] = 1;
                if(desiredTotal - i <= 0 || !canWin(desiredTotal - i, state, map)){
                    map.put(key, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
              
            }
        }
        map.put(key, false);
        return false;
    }
}
// @lc code=end

