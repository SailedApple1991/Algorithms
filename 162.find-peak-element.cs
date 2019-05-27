/*
 * @lc app=leetcode id=162 lang=csharp
 *
 * [162] Find Peak Element
 */
 //Binary Search Time Complexity: O(logn) Space Complexity : O(1)
public class Solution {
    public int FindPeakElement(int[] nums) {
        int left = 0, right = nums.Length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            //case 1: right curve
            if(nums[mid] < nums[mid - 1]){
                right = mid;
            }
            //case 2: left curve
            else if(nums[mid] < nums[mid + 1]){
                left = mid;
            }
            //case 3: equal 
            else{
                right = mid;
            }
        }

        return nums[left] > nums[right] ? left : right;
    }
}

