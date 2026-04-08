class Twitter {
    HashMap<Integer, HashSet<Integer>> followers = new HashMap<>();
    List<int[]> tweets = new ArrayList<>();
    int time = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{userId, tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> k_tweets = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        for(int[] tweet:tweets){
            if(tweet[0]==userId || (followers.containsKey(userId) && followers.get(userId).contains(tweet[0]))){
                k_tweets.add(new int[]{tweet[1], tweet[2]});
            }
            if(k_tweets.size() > 10) {
                k_tweets.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!k_tweets.isEmpty()) res.add(k_tweets.poll()[0]);
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            followers.put(followerId, new HashSet<>());
        }     
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId))
            followers.get(followerId).remove(followeeId);
    }
}
