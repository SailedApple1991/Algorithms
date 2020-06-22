import java.util.HashMap;

import javax.xml.soap.Node;



/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> ptMap = new HashMap<>();
        //first loop : save the node:
        Node h = head;
        while(h != null){
            Node t = new Node(h.val);
            ptMap.put(h, t);
            h = h.next;
        }

        h = head;
        while(h != null){
            if(h.next != null){
                ptMap.get(h).next = ptMap.get(h.next);
            }
            if(h.random != null){
                ptMap.get(h).random = ptMap.get(h.random);
            }
            h = h.next;
        }
        return ptMap.get(head);
    }
}
// @lc code=end

