/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
/*
ime Complexity: O(NK)O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.

Space Complexity: O(NK)O(NK), the total information content stored in ans.
*/
import java.util.*;// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        HashMap <String, List<String>> countMap = new HashMap<>();
        int[] charArray = new int[26];
        for(String str : strs){
            Arrays.fill(charArray, 0);
            char[] tmp = str.toCharArray();
            for(char c : tmp){
                charArray[c - 'a']++;
            }            
            StringBuilder sb = new StringBuilder();
            for(int a : charArray){
                sb.append("#");
                sb.append(a);
            }
            String fi = sb.toString();
            List<String> countList = countMap.getOrDefault(fi.toString(), new ArrayList<>());
            countList.add(str);
            countMap.put(fi, countList);
        }
        for(List<String> li : countMap.values()){
            res.add(li);
        }
        return res;
    }
}
// @lc code=end

