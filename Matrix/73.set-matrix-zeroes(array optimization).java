/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        //optimize the space usage from O(mn) to O(m + n); time O(mn); or use set
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for(int i = 0; i < rows.length; i++){
            if(rows[i]){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < columns.length; i++){
            if(columns[i]){
                for(int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
// @lc code=end

