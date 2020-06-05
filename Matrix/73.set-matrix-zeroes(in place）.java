/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        //in place optimization
        int modified = -1000000000;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < matrix.length; k++){
                        if(matrix[k][j] != 0){
                            matrix[k][j] = modified;
                        }
                    }
                    for(int k = 0; k < matrix[i].length; k++){
                        if(matrix[i][k] != 0){
                            matrix[i][k] = modified;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == modified){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end

