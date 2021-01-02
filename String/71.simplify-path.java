import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 *
 * https://leetcode.com/problems/simplify-path/description/
 *
 * algorithms
 * Medium (33.28%)
 * Likes:    1002
 * Dislikes: 2013
 * Total Accepted:    235.8K
 * Total Submissions: 704.5K
 * Testcase Example:  '"/home/"'
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other
 * words, convert it to the canonical path.
 * 
 * In a UNIX-style file system, a period '.' refers to the current directory.
 * Furthermore, a double period '..' moves the directory up a level.
 * 
 * Note that the returned canonical path must always begin with a slash '/',
 * and there must be only a single slash '/' between two directory names. The
 * last directory name (if it exists) must not end with a trailing '/'. Also,
 * the canonical path must be the shortest string representing the absolute
 * path.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory
 * name.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the
 * root level is the highest level you can go.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are
 * replaced by a single one.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: path = "/a/./b/../../c/"
 * Output: "/c"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid Unix path.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        //if empty return '/'
        if(path == null || path.length() == 0){
            return "/";
        }
        int len = path.length();
        List<String> names = new ArrayList<>();
        //gain every dir name
        for(int i = 0; i < len; i++){
            if(path.charAt(i) != '/'){
                int j = i;
                while( j < len && path.charAt(j) != '/'){
                    j++;
                }
                names.add(path.substring(i, j));
                i = j;
            }
        }

        List<String> res = new ArrayList<>();
        //construt the path
        for(int i  = 0; i < names.size(); i++){
            //if '..' need to judge
            if(names.get(i).equals("..")){
                //if the names still have dir, we need to return to last level or ignore it
                if(res.size() > 0){
                    res.remove(res.size() - 1);
                }
            }
                else if(!names.get(i).equals(".")){
                    res.add(names.get(i));
                }
                //if none, then it shoule be '.'
        }
        return "/" + String.join("/", res);
    }
}
// @lc code=end

