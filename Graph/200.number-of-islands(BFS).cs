private static int minDays(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int days = 0;
        int humanCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    humanCount++;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty() && humanCount > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] zombie = queue.poll();
                for (int[] dir : directions) {
                    int newX = zombie[0] + dir[0];
                    int newY = zombie[1] + dir[1];

                    if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[newX][newY] == 0) {   // when the new coordinates doesn't exceed the boundaries of the matrix or the new valid coordinate is a human, only then turn that to a zombie
                        matrix[newX][newY] = 1;
                        queue.offer(new int[]{newX, newY});   // now that new coordinate is a zombie, add that to the queue so it can be processed in the next level
                        humanCount--;
                    }
                }
            }
            days++;
        }
        return humanCount == 0 ? days : -1;
    }/*
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
                if(isBoundary(grid,tmp.x + dx[x], tmp.y + dy[x] )) continue;
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

