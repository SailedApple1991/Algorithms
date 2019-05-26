/*
 * @lc app=leetcode id=673 lang=csharp
 *
 * [673] Number of Longest Increasing Subsequence
 */
public class Solution {
    public int FindNumberOfLIS(int[] nums) {
        int max = 1;
        int[,] dp =  new int[nums.Length, nums.Length];
         for(int i = 0; i < nums.Length; i++){
            for(int j = 0; j < nums.Length; j++){
                dp[i, j] = 1;
            }
        }

        for(int i = 0; i < nums.Length; i++){
            for(int j = i; j < nums.Length; j++){
                // if(i == j|| dp[i,j] == 0){
                //     dp[i, j] = 1;
                   
                // }
                // else{
                    if(nums[j - 1] <= nums[j]){
                        dp[i, j] = dp[i, j - 1] + 1;
                        max = max < dp[i, j] ? dp[i, j] : max;
                    }
                
                //}
            }
        }
        int count = 0;
        for(int i = 0; i < nums.Length; i++){
            for(int j = 0; j < nums.Length; j++){
                if(max == dp[i,j]){
                    count++;
                }
            }
        }

        return count;

    }
}

