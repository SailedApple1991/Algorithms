/*
 * @lc app=leetcode id=200 lang=csharp
 *
 * [200] Number of Islands
 */
 //BFS C# version   
public class Solution {
    class Point{
        public int x;
        public int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
    }
    }
    public int NumIslands(char[][] grid) {
        //if(grid == null || grid.Length == 0 || grid[0].Length == 0) return 0;
        int count = 0;
        Queue<Point> queue = new Queue<Point>();
        for(int i = 0; i < grid.Length; i++){
            for(int j = 0; j  < grid[0].Length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, queue, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, Queue<Point> queue, int i, int j){
        Point ori = new Point(i, j);
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0 ,0, 1, -1}; 
        queue.Enqueue(ori);
        while(queue.Count != 0){
            Point tmp = queue.Dequeue();
            for(int x = 0; x < 4; x++){
                if(!isBoundary(grid,tmp.x + dx[x], tmp.y + dy[x] )) continue;
                Point pt = new Point(tmp.x + dx[x], tmp.y + dy[x]);
                if(grid[pt.x][pt.y] == '1'){
                    queue.Enqueue(pt);
                    grid[pt.x][pt.y] = '0';
                }
                }
            }


    }

    private Boolean isBoundary(char[][] grid, int i, int j){
        return i >= 0 && i < grid.Length && j >= 0 && j < grid[0].Length;
    }
}

