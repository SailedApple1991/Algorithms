/*
 * @lc app=leetcode id=62 lang=csharp
 *
 * [62] Unique Paths
 */
public class Solution {
    public int UniquePaths(int m, int n) {
        int count = 0;
        dfs(0, 0, m, n, count);
        return count;
    }
    private void dfs(int x, int y, int m, int n, int count){
        if(x == m && y == n) return ;
        if(x == m){
            count++;
            dfs(x, y + 1,m, n, count);
        }
        else if(y == n){
            count++;
            dfs(x + 1, y, m, n, count);
        }
        else{
            count++;
        dfs(x, y + 1, m, n, count);
        count++;
        dfs(x + 1, y, m, n, count);
        }
    }
}

