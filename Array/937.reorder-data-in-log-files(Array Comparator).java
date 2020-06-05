import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution implements Comparator{
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0 || logs == null) return null;
        int size = logs.length;
        String[] res = new String[size];
        List<String> tmp = new ArrayList<String>();
        int cur = size - 1;
        for(int i = size - 1; i >= 0; i--){
            int index = logs[i].indexOf(' ');
            String body = logs[i].substring(index + 1);
            if(Character.isDigit(body.charAt(0))){
                res[cur--] = logs[i];
                
            }
            else{
                tmp.add(new String(logs[i]));
            }
        }
        Solution sln = new Solution();
        Collections.sort(tmp, sln);
        cur = 0;
        for(String s : tmp){
            res[cur++] = s;
        }
        return res;
    }


	@Override
	public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        String a = (String)o1;
        String b = (String)o2;
        String body1 = a.substring(a.indexOf(' '));
        String body2 = b.substring(b.indexOf(' '));
		return body1.compareTo(body2);
	}
}
// @lc code=end

