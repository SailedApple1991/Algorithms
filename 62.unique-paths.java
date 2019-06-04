/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */
class Solution {
    public int UniquePaths(int m, int n) {
        int count = 0;
        dfs(0, 0, m, n, count);
        return count;
    }

    private void dfs(int x, int y, int m, int n, int count) {
        if (x == m && y == n)
            return;
        if (x == m) {
            dfs(x, y + 1, m, n, count + 1);
        } else if (y == n) {
            dfs(x + 1, y, m, n, count + 1);
        } else {
            dfs(x, y + 1, m, n, count + 1);
            dfs(x + 1, y, m, n, count + 1);
        }
    }
}
