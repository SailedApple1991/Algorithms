import java.util.HashMap;

import sun.net.www.content.text.plain;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class Point{
    public Object key;
    public Object value;
    public Point next = null;
    public Point prev = null;
    public Point(Object key, Object value){
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList{
    private Point dummyHead;
    private Point tail;
    public DoubleLinkedList(){
        this.dummyHead = new Point(null, null);
        this.tail = this.dummyHead;
    }
    public void insert(Point pt){
        //insert after tail
        tail.next = pt;
        pt.prev = tail;
        tail = pt;
    }

    public void delete(Point pt){
        //Bi-Way.
        //deal with next
        pt.prev.next = pt.next;
        //judge if pt is tail or not
        if(pt.next != null){
            pt.next.prev = pt.prev;
        }
        else{
            tail = pt.prev;
        }
        pt.next = null;
        pt.prev = null;
    }

    public Point getHead(){
        return dummyHead.next;
    }

    public void moveToTail(Point pt){
        delete(pt);
        insert(pt);
    }
}
class LRUCache {

    private int capacity;
    private HashMap<Integer, Point> countMap = new HashMap<>();;
    private DoubleLinkedList list = new DoubleLinkedList();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(countMap.containsKey(key)){
            int value = (int)countMap.get(key).value;
            list.moveToTail(countMap.get(key));
            return value;    
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //if key exists, dont need to insert, just update the value
        if(countMap.containsKey(key)){
            Point pt = countMap.get(key);
            pt.value = value;
            list.moveToTail(pt);
        }
        //need to check capacity
        else{
            if(countMap.size() == capacity){
                //if reach, need to delete the head point from map and list and then insert
                Point head = list.getHead();
                list.delete(head);
                countMap.remove(head.key);
                //and then insert
                Point pt = new Point(key, value);
                list.insert(pt);
                countMap.put(key, pt);
            }
            else{
                Point pt = new Point(key, value);
                list.insert(pt);
                countMap.put(key, pt);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

