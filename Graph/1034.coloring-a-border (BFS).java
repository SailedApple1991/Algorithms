import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1034 lang=java
 *
 * [1034] Coloring A Border
 */
class Solution {
    //BFS
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        
        int oldColor = grid[r0][c0];
        bfs(grid, oldColor, color,r0, c0);
        return grid;
    }

    private void bfs(int[][] grid, int oldColor, int color, int r0, int c0){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r0, c0));
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        List<Point> res =  new ArrayList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()){
            Point pt = queue.poll();
            for(int i = 0; i < 4; i++){
                Point tmp = new Point(pt.x + dx[i], pt.y + dy[i]);
                if(isBoundery(grid, tmp) && grid[tmp.x][tmp.y] == oldColor){
                    if(!isVisited[tmp.x][tmp.y]){
                        queue.offer(tmp);
                        isVisited[tmp.x][tmp.y] = true;
                    }
                }
                else{
                    res.add(pt);
                }
            }
        }
        for(Point p : res){
            grid[p.x][p.y] = color;
        }

    }

    private boolean isBoundery(int[][] grid, Point pt){
        return pt.x >= 0 && pt.x < grid.length && pt.y >= 0 && pt.y < grid[0].length;
    }
}

