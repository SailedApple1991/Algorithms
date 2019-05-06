/*
 * @lc app=leetcode id=56 lang=csharp
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (35.33%)
 * Total Accepted:    329.4K
 * Total Submissions: 932.4K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
public class Solution {
    //same dir two pointers
    public int[][] Merge(int[][] intervals) {
        if(intervals == null || intervals.Length <= 1) return intervals;
        Array.Sort(intervals, (a, b) => selfDefinedComparator(a, b));
        List<int[]> res = new List<int[]>();
        //int[][] res = new int[intervals.Length][];
        int left = 0, right = 1; 
        while(right < intervals.Length){
            //update left end and wait for append
            if(intervals[left][1] >= intervals[right][0]){
                intervals[left][1] = Math.Max(intervals[left][1], intervals[right][1]);
    
            }
            else{
                res.Add(intervals[left]);
                left = right;
            }
            right++;
        }
        //Console.WriteLine(res.Count);
        res.Add(intervals[left]);
        return res.ToArray();
    }

    private int selfDefinedComparator(int[] a, int[] b){
        return a[0].CompareTo(b[0]);
    }
}

