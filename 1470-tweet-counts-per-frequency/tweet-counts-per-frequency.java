class TweetCounts {
    TreeMap<Integer,Map<String,Integer>> mp;
    public TweetCounts() {
        mp = new TreeMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        Map<String,Integer> lmp=mp.get(time);
        if(lmp!=null)
            lmp.put(tweetName,lmp.getOrDefault(tweetName,0)+1);
        else
        {
            lmp= new HashMap<>();
            lmp.put(tweetName,1);
            mp.put(time,lmp);
        }       
    }
    
    List<List<Integer>> getIntervals(String freq,int startTime, int endTime)
    {
        int interval=86399;
        if(freq.equals("minute"))
            interval=59;
        else if(freq.equals("hour"))
            interval=3599;
        List<List<Integer>> ls = new ArrayList<>();
        while(startTime<=endTime)
        {
            ls.add(List.of(startTime,Math.min(startTime+interval,endTime)));
            startTime+=interval+1;
        }
        return ls;
    }
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<List<Integer>> ls =getIntervals(freq,startTime,endTime);
        List<Integer> ans = new ArrayList<>();
        for(List<Integer> tp : ls)
        {
                int sum=0;
                for(Map.Entry<Integer,Map<String,Integer>> lmp : mp.subMap(tp.get(0), true, tp.get(1), true).entrySet())
                    {
                        sum+=lmp.getValue().getOrDefault(tweetName,0);
                    }
                ans.add(sum);
        }
        return ans;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */