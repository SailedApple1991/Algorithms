import java.util.*; 
/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

import javax.print.attribute.standard.Media;

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        //brute force
        // space O(mn) time O(mn(m/n))
        int[][] ref = new int[matrix.length][matrix[0].length];
        //copy the matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                ref[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(ref[i][j] == 0){
                    for(int k = 0; k < matrix.length; k++){
                        matrix[k][j] = 0;
                    }
                    for(int l = 0; l < matrix[0].length; l++){
                        matrix[i][l] = 0;
                    }
            }

        }
        
    }
}
}
// @lc code=end

