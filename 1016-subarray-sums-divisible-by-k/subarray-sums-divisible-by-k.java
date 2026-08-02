class Solution {
    public int subarraysDivByK(int[] nums, int k) {
    Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
    int ans=0;

    for(int i=1;i<nums.length;i++)
        nums[i]+=nums[i-1]; 
    
    int reminder=0;
    for(int num :nums)
    {
        reminder=num%k;
        if(reminder==0)
            ans++;

        if(mp.containsKey(reminder))
            ans+=mp.get(reminder);
        
        if(reminder<0)
        {
            if(mp.containsKey(k+reminder))
            ans+=mp.get(k+reminder);
        
        }
        else
        {
            if(mp.containsKey(reminder-k))
            ans+=mp.get(reminder-k);
        }

        mp.put(reminder,mp.getOrDefault(reminder,0)+1);
    }

    return ans;
    }
}