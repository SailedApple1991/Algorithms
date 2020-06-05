import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
import java.util.Map;

// @lc code=start
class Solution {
//TIME: O(mnlogn)
//Space: O(mn)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res; 
        HashMap<String, List<String>> countMap = new HashMap<>();
        //loop - O(m)
        for(String str : strs){
            char[] charArray = str.toCharArray();
            //sort the array which take O(nlogn)
            Arrays.sort(charArray);
            String tmp = String.valueOf(charArray);
            List<String> tmpList = countMap.getOrDefault(tmp, new ArrayList<String>());
            tmpList.add(str);
            countMap.put(tmp, tmpList);
        }
        res = new ArrayList(countMap.values());
        return res;
    }
}
// @lc code=end

