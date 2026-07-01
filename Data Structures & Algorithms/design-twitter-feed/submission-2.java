class Twitter {

    private Map<Integer,List<int[]>>tweet;
    private Map<Integer,Set<Integer>> follow;
    private int time;
    public Twitter() {
        this.time=0;
        this.tweet= new HashMap<>();
        this.follow= new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweet.containsKey(userId))
        {
            tweet.put(userId,new ArrayList<>());
        }
        tweet.get(userId).add(new int[]{time++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
       List<Integer> result= new ArrayList<>();
    //    created maxHeap 
       PriorityQueue<int []> maxHeap= new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        Set<Integer> users= new HashSet<>();
        users.add(userId);
        if (follow.containsKey(userId)) {
        users.addAll(follow.get(userId));
        }   
        for(int follower: users)
        {
            List<int[]> followerTweet=tweet.get(follower);
            if (followerTweet == null) continue;
            int index= followerTweet.size()-1;
            for(int i=index;i>=0  && i >= followerTweet.size() - 10;i--)
            {
                maxHeap.offer(followerTweet.get(i));
            }
        }

        while(!maxHeap.isEmpty() && result.size()<10)
        {
            int [] curr= maxHeap.poll();
            result.add(curr[1]);
        }
        return result;
       
    }
    
    public void follow(int followerId, int followeeId) {
        follow.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);  
    }
    
    public void unfollow(int followerId, int followeeId) {
       Set<Integer> follwers = follow.get(followerId);
        if (follwers != null) {
            follwers.remove(followeeId);
        }
        
    }
}
