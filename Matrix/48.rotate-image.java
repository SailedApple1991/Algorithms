/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int size = matrix.length;
        int left = 0, down = matrix.length - 1, top = 0, right = matrix.length - 1;
        //TIME O(n) Space: O(N^2)??????
        while(size > 1){
            for(int i = 0; i < size - 1; i++){
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[down - i][left];
                matrix[down - i][left] = matrix[down][right - i];
                matrix[down][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            top++;
            left++;
            right--;
            down--;
            size -= 2;
        }
    }
}
// @lc code=end

