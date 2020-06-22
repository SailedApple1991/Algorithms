/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //quick slow counter
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            if(fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow ) return true;
        }
        return false;
    }
}
// @lc code=end

