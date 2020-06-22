import java.util.*;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Biway BFS O(N*26^1/2)
        int level = 0;
        if(!wordList.contains(endWord)) return level;
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            level++;
            //if set2 < set1, swap keep set1 as for loop later, every step looping set for longer length
            if(beginSet.size() > endSet.size()){
                HashSet<String> tempSet = new HashSet<>();
                tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }

            HashSet<String> ws = new HashSet<>();

            for(String s : beginSet){
                char[] charArray = s.toCharArray();
                for(int i = 0; i < beginWord.length(); i++){
                    char oldChar = charArray[i];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        charArray[i] = ch;
                        if(ch == oldChar) continue;
                        String tmp = new String(charArray);
                        //first check if it is end word
                        if(endSet.contains(tmp)) return level + 1;
                        if(!wordSet.contains(tmp)) continue;
                        wordSet.remove(tmp);
                        ws.add(tmp);
                    }
                    charArray[i] = oldChar;
                }
                beginSet = ws;
            }
        }

        return 0;
    }
}
// @lc code=end

