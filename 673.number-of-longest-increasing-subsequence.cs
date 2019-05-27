/*
 * @lc app=leetcode id=673 lang=csharp
 *
 * [673] Number of Longest Increasing Subsequence
 */
public class Solution {
//     * len[k] = max(len[k], len[i] + 1), for all 0 <= i < k and nums[i] < nums[k] 
// * cnt[k] = sum(cnt[i]), for all 0 <= i < k and len[k] = len[i] + 1

    public int FindNumberOfLIS(int[] nums) {
        int max = 0, ans = 0;
        int[] len = new int[nums.Length];
        int[] cnt = new int[nums.Length];
        for(int i =0; i < nums.Length; i++){
            len[i] = 1;
            cnt[i] = 1;
        }
        for(int i = 1; i < nums.Length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(len[j] >= len[i]){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                        
                    }
                   else if(len[j] + 1 == len[i]){
                       cnt[i] += cnt[j];
                   }
                }
            }
        }

        for(int i = 0; i < len.Length; i++){
            max = max > len[i] ? max : len[i];
        }

        for(int i = 0; i < len.Length; i++){
            if(len[i] == max){
                ans += cnt[i];
            }
        }
        return ans;
    }
}

