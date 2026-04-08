class Twitter {
    HashMap<Integer, HashSet<Integer>> followers = new HashMap<>();
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();
    // List<int[]> tweets = new ArrayList<>();
    int time = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) tweets.put(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> k_tweets = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        if(followers.containsKey(userId)){
            for(int followee: followers.get(userId)){
                for(int[] tweet: tweets.get(followee)){
                    k_tweets.add(new int[]{tweet[0], tweet[1]});
                
                    if(k_tweets.size() > 10) {
                        k_tweets.poll();
                    }
                }
            }
        }
        if(tweets.containsKey(userId)){
            for(int[] tweet: tweets.get(userId)){
                k_tweets.add(new int[]{tweet[0], tweet[1]});
                
                if(k_tweets.size() > 10) {
                    k_tweets.poll();
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!k_tweets.isEmpty()) res.add(k_tweets.poll()[0]);
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
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
