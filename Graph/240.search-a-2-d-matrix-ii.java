/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // compare with each row and column
        // each row : right most
        // each column : downmost
        //if the target greater than the value, target is not in that row
        //if the target less than the value, target cannot in the entire column
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while(col >= 0 && row  <= matrix.length - 1){
            if(target == matrix[row][col]){
                return true;
            }
            else if(target < matrix[row][col]){
                col --;
            }
            else{
                row ++;
            }
        }

        return false;
    }
}

