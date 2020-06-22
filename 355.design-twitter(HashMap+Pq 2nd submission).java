import java.util.*;

/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Tweet{
    //single linkedlist
    int Id;
    int timeStamp;
    Tweet next;
    public Tweet(int timeStamp, int tweetId){
        this.Id = tweetId;
        this.timeStamp = timeStamp;
    }
}
class Twitter {
    private static int timeStamp;
    private HashMap<Integer, HashSet<Integer>> followersMap;
    private HashMap<Integer, Tweet> tweetsMap;
    private static PriorityQueue<Tweet> pq;
    /** Initialize your data structure here. */
    public Twitter() {
        timeStamp = 0;
        followersMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        pq = new PriorityQueue<>((o1, o2) -> o2.timeStamp - o1.timeStamp);
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        Tweet tw = new Tweet(timeStamp, tweetId);
        if(tweetsMap.containsKey(userId)){
            Tweet oldTweet = tweetsMap.get(userId);
            tw.next = oldTweet;
        }
        tweetsMap.put(userId, tw);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        pq.clear();
        
        if(tweetsMap.containsKey(userId)){
            Tweet tw = tweetsMap.get(userId);
            pq.offer(tw);
        }

        HashSet<Integer> followeeSet = followersMap.get(userId);
        if(followeeSet != null && followeeSet.size() > 0){
            for(int usr : followeeSet){
                Tweet tweet = tweetsMap.get(usr);
                if(tweet != null){
                    pq.offer(tweet);
                }
            }
        }
        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while(count < 10 && !pq.isEmpty()){
            Tweet tw = pq.poll();
            res.add(tw.Id);
            if(tw.next != null){
                pq.offer(tw.next);
            }
            count++;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId) return;
        else{
            HashSet<Integer> followeeSet = followersMap.get(followerId);
            if(followeeSet != null){
                if(followeeSet.contains(followeeId)) return;
                followeeSet.add(followeeId);
            }
            else{
                HashSet<Integer> set = new HashSet<>();
                set.add(followeeId);
                followersMap.put(followerId, set);
            }
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId == followerId) return;
        else{
            HashSet<Integer> followeeSet = followersMap.get(followerId);
            if(followeeSet != null){
                followeeSet.remove(followeeId);
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

