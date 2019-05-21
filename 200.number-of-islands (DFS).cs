/*
 * @lc app=leetcode id=200 lang=csharp
 *
 * [200] Number of Islands
 */
 //dfs csharp
public class Solution {
    public int NumIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.Length == 0 || grid[0].Length == 0) return count;
        for(int i = 0; i < grid.Length; i++){
            for(int j = 0; j  < grid[0].Length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i , j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y){
        if(!isBoundary(grid, x, y) || grid[x][y] == '0') return;
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++){
            dfs(grid, x + dx[i], y + dy[i]);
        }
        
    }

    private Boolean isBoundary(char[][] grid, int x, int y){
        return x >= 0 && x < grid.Length && y >= 0 && y < grid[0].Length;
    }
}

