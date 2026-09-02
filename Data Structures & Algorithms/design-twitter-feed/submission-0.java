class Twitter {

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> following;
    Map<Integer, List<Tweet>> tweets;
    int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }

        tweets.get(userId).add(new Tweet(tweetId, time));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        if(tweets.containsKey(userId)){
            for (Tweet tweet: tweets.get(userId)){
                maxHeap.offer(tweet);
            }
        }

        if(following.containsKey(userId)){
            for (int followeeId: following.get(userId)){
                if(tweets.containsKey(followeeId)){
                    for(Tweet tweet: tweets.get(followeeId)){
                        maxHeap.offer(tweet);
                    }
                }
            }
        }

        while(!maxHeap.isEmpty() && result.size() < 10){
            Tweet tweet = maxHeap.poll();
            result.add(tweet.tweetId);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            following.put(followerId, new HashSet<>());
        }

        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
    }
}

