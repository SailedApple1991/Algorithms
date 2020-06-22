import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class Point{
    int key;
    int value;
    Point next = null;
    int frequency = 1;
    public Point(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LFUCache {
    //double HashMap
    HashMap<Integer, Point> ptMap = new HashMap<>();
    HashMap<Integer, LinkedList<Point>> frequencyMap = new HashMap<>();  
    int capacity;
    int min_frequency;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        min_frequency = 1;
    }
    
    public int get(int key) {
        //if key does not exist, return -1
        if (!ptMap.containsKey(key))
            return -1;
        //else get the node, update the node and return the node value.
        Point pt = ptMap.get(key);
        update(pt);
        return pt.value;
    }
    
    private void update(Point pt) {
        //get the current node frequency
        int frequency = pt.frequency;
        //if exist linkedlist for the frequency, get the list.
        if(frequencyMap.containsKey(frequency)){
            LinkedList<Point> freSet = frequencyMap.get(frequency);
            //remove the point from the list because of the increment of its frequency
            freSet.remove(pt);
            //if the set is empty and frequency equal to min_frequency. min frequency ++;
            if(freSet.isEmpty() && frequency == min_frequency){
                frequencyMap.remove(frequency);
                min_frequency++;
            }
            //update the pt frequency
            frequency = ++pt.frequency;
            System.out.println("updated frequency:" + frequency + "updated node frequency:" + pt.frequency);
            if(frequencyMap.containsKey(frequency)){
                freSet = frequencyMap.get(frequency);
                freSet.add(pt);
            }
            else{
                 freSet = new LinkedList<Point>();
                 freSet.add(pt);
                 frequencyMap.put(frequency, freSet);
            }
        }
        // if the list does not have the frequency
        else{
            //create the new frequency set and and the point in and add it into frequency map
            LinkedList<Point> freSet = new LinkedList<Point>();
            freSet.add(pt);
            frequencyMap.put(pt.frequency, freSet);
        }
    }

    public void put(int key, int value) {
        //如果cap<=0，直接return
        //如果key已经存在，update(node)，

        if(capacity <= 0) return;
        //if the key contains in the map,
        if(ptMap.containsKey(key)){
            //update the map and update the frequency map
            Point pt = ptMap.get(key);
            pt.value = value;
            ptMap.put(key, pt);
            update(pt);
        }
        else{
          
            Point pt = new Point(key, value);
            ptMap.put(key, pt);
            if(!frequencyMap.containsKey(pt.frequency)){
                LinkedList<Point> tmp = new LinkedList<Point>();
                tmp.add(pt);
                frequencyMap.put(pt.frequency, tmp);
            }
            else{
                LinkedList<Point> tmp = frequencyMap.get(pt.frequency);
                System.out.println("key is" + pt.key + "=============frequency is================" + pt.frequency);
                tmp.add(pt);
            }
            if(ptMap.size() > capacity){
                System.out.println("=============start================");
                System.out.println(min_frequency);
                System.out.println("=============================");
                System.out.println(frequencyMap.size());
                System.out.println("=============end================");
                LinkedList<Point> temp = frequencyMap.get(min_frequency);
                System.out.println("=============list:================");
                System.out.println(temp.getFirst().key);
                System.out.println(temp.getLast().key);
                Point tmp = temp.removeFirst();
                System.out.println("=============removed point================");
                System.out.println("key" + tmp.key);
                System.out.println("value" + tmp.value);
                System.out.println("=============removed end================");
                ptMap.remove(tmp.key);
                
            }
            min_frequency = 1;
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

