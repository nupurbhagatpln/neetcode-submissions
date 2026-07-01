class Twitter {
    Map<Integer,List<int[]>> tweet;
    Map<Integer, Set<Integer>> follow;
    int time;

    public Twitter() {
        time=0;
        tweet= new HashMap<>();
        follow= new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweet.containsKey(userId))
        {
            tweet.put(userId, new ArrayList<>());
        }
        tweet.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)-> (b[0]-a[0]));
        Set<Integer> user= new HashSet<>();
        if(follow.containsKey(userId))
        {
            user.addAll(follow.get(userId));
        }
        user.add(userId);
        
        for(int u: user)
        {
            List<int[]> utweets= new ArrayList<>();
            utweets= tweet.get(u);
            if(utweets!=null)
            {
                int index= utweets.size()-1;
                for(int i=index;i>=0 && i>=index-10;i--)
                {
                    maxHeap.add(utweets.get(i));
                }
            }
        }
        List<Integer> result= new ArrayList<>();
        while(!maxHeap.isEmpty() && result.size()!=10)
        {
            result.add(maxHeap.poll()[1]);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> users= follow.get(followerId);
        if(users!=null)
        {
            users.remove(followeeId);
        }
    }
}
