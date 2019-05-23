/*
 * @lc app=leetcode id=852 lang=csharp
 *
 * [852] Peak Index in a Mountain Array
 */
 //Two pointers with binary search
 //Time Complexity : O(logn) Space : O(1)
public class Solution {
    public int PeakIndexInMountainArray(int[] A) {
        int left = 0, right = A.Length - 1, res = 0;
        while(left + 1 < right){

            int mid = left + (right - left) / 2;
            if(A[mid] < A[mid + 1]){
                left = mid + 1;
            }
            else right = mid;
        }
        if(A[left] > A[right]) return left;
        else return right;
    }

}

