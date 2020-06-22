import java.util.*;

import sun.awt.image.OffScreenImage;
import sun.font.TrueTypeGlyphMapper;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //BFS (O(N*26))
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashSet<String> wordSet = new HashSet<>(wordList);
        //count the visited words
        HashMap<String, Integer> visited = new HashMap<>();
        visited.put(beginWord, -1);
        int level = 0;
        //queue to record the current point that visiting
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            level++;
            for(int size = queue.size();  size > 0; size--){
                String wrd = queue.poll();
                char[] charSet = wrd.toCharArray();
                
                for(int i = 0; i < beginWord.length(); i++){
                    char oldChar = wrd.charAt(i);
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(ch == oldChar) continue;
                        charSet[i] = ch;
                        String tmp = String.valueOf(charSet);
                        //found the solution
                        if(tmp.equals(endWord)) return level + 1;
                        //Not in dict, skip it
                        if(!wordSet.contains(tmp)) continue;
                        //remove the new word from set
                        wordSet.remove(tmp);
                        //add the new word to queue
                        queue.add(tmp);
                    }
                    charSet[i] = oldChar;
                }
        }
    }
  // now count the length   
        return 0;
    }
}
// @lc code=end

