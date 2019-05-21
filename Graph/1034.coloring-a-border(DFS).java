/*
 * @lc app=leetcode id=1034 lang=java
 *
 * [1034] Coloring A Border
 */
class Solution {
    boolean[][] isVisited;
    int oldColor, Color;
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        //DFS
        oldColor = grid[r0][c0];
        Color = color;
        isVisited = new boolean[grid.length][grid[0].length];
        dfs(grid, r0, c0);
        return grid;
    }

    private boolean dfs(int[][] grid, int r, int c){
        if(!isBoundary(grid, r, c)) return false;
        if(isVisited[r][c]) return true;
        if(grid[r][c] !=  oldColor){
           return false;
        }
        isVisited[r][c] = true;
        
        if(!(dfs(grid, r + 1, c) && dfs(grid, r - 1, c) && dfs(grid, r, c + 1) && dfs(grid, r, c - 1))){
            grid[r][c] = Color;           
        }

        return true;
    }

   private boolean isBoundary(int[][] grid, int x, int y){
       return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length; 
   } 
}

