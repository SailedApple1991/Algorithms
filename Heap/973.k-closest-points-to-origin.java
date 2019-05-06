import java.util.Comparator;
import java.util.PriorityQueue;

import com.sun.javafx.css.CalculatedValue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 *
 * algorithms
 * Medium (63.53%)
 * Total Accepted:    44.5K
 * Total Submissions: 70.1K
 * Testcase Example:  '[[1,3],[-2,2]]\n1'
 *
 * We have a list of points on the plane.  Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean
 * distance.)
 * 
 * You may return the answer in any order.  The answer is guaranteed to be
 * unique (except for the order that it is in.)
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation: 
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * 
 * 
 * 
 */
class Solution {
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length == 0 || K == 0) return new int[0][0];
        PriorityQueue<Point> queue = new PriorityQueue<>(K, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b){
              int diff = calDiff(b, a); 
              if(diff == 0){
                    diff =  b.x - a.x;
              }
              if(diff == 0) diff =  b.y - a.y;
              return diff;
            }
        });
        for(int i = 0; i < points.length; i++){
            Point pt = new Point(points[i][0], points[i][1]);
            queue.add(pt);
            if(queue.size() > K) queue.poll();
        }
        System.out.print(K);
        int[][] res = new int[K][2];
        int size = queue.size();
        System.out.print(size);
        while(!queue.isEmpty()){
            res[--size][0] = queue.peek().x;
            res[size][1] =queue.poll().y;
        }
        return res;
    }

    private int calDiff(Point a, Point b){
        return (a.x * a.x + a.y * a.y) - (b.x * b.x + b.y * b.y);
    }
    
}

