import java.util.*;

/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
class Tweets{
    int userId;
    int times;
    int tweetId;
    public Tweets(int userId, int tweetId, int times){
        this.userId = userId;
        this.tweetId = tweetId;
        this.times = times;
    }
}

class TweetsComparator implements Comparator<LinkedList<Tweets>> {
    public int compare(LinkedList<Tweets> s1, LinkedList<Tweets> s2){
        System.out.println("s1 size");
        System.out.println(s1.size());
        System.out.println("s2 size");
        System.out.println(s2.size());
        if(s1.getLast().times > s2.getLast().times){
            return -1;
        }
        else if(s1.getLast().times < s2.getLast().times){
            return 1;
        }
        return 0;
    }
}
class Twitter {
    
    /** Initialize your data structure here. */
    HashMap<Integer, HashSet<Integer>> followMap; //key : other user id
    HashMap<Integer, LinkedList<Tweets>> tweets; //key: all tweets user send -userid
    int times;
    public Twitter() {
        times = 0;
        followMap = new HashMap<>();
        tweets = new HashMap<>();
    }

    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        times++;
        Tweets tweet = new Tweets(userId, tweetId, times);
        LinkedList<Tweets> listofTweets = tweets.getOrDefault(userId, new LinkedList<Tweets>());
        listofTweets.add(tweet);
        tweets.put(userId, listofTweets);
    }

    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<LinkedList<Tweets>> pq = new PriorityQueue<>(new TweetsComparator());
        List<Integer> res = new ArrayList<>();
        //if user send tweet him/herself, add him/herself in
        if(tweets.containsKey(userId)){
            // System.out.println("adding userid " + userId + " tweets to pq...........");
            // System.out.println("last element of tweets queue:  " + tweets.get(userId).getLast() + "...........");
            pq.add((LinkedList<Tweets>)tweets.get(userId).clone());
        }
        //if the user follows other users...
        if(followMap.containsKey(userId)){
            // System.out.println("checking userid " + userId + " followers...........");
            //loop through the users
            for(int usr : followMap.get(userId)){
                //if the user send tweets
                // System.out.println("userid " + usr + " followee...........");
                if(tweets.containsKey(usr)){
                    // System.out.println("map size" + tweets.size());
                    // System.out.println("userid " + usr + " tweets: " + tweets.get(usr).toString());
                    // System.out.println("adding userid " + usr + " tweets to pq...........");
                    // System.out.println("last element of tweets queue:  " + tweets.get(usr).getLast() + "...........");
                    pq.add((LinkedList<Tweets>)tweets.get(usr).clone());
                    // System.out.println("now pq size");
                    // System.out.println(pq.size());
                }
            }
        }
        int count = 0;
        System.out.println("pq size");
        System.out.println(pq.size());
        while(count < 10 && !pq.isEmpty()){
            LinkedList<Tweets> sentTweets = pq.poll();
            // System.out.println("The last element of the list is :" + sentTweets.getLast());
            res.add(sentTweets.getLast().tweetId);
            sentTweets.removeLast();
            if(!sentTweets.isEmpty()){
                pq.add(sentTweets);
            }
            count++;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        // System.out.println("following");
        if(followerId != followeeId){
            HashSet<Integer> followeeSet= followMap.getOrDefault(followerId, new HashSet<>());
            followeeSet.add(followeeId);
            followMap.put(followerId, followeeSet);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        // System.out.println("unfollowing");
        HashSet<Integer> followeeList = followMap.getOrDefault(followerId, new HashSet<>());
        if(followeeList.contains(followeeId)){
            followeeList.remove(followeeId);
            followMap.put(followerId, followeeList);
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

