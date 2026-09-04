class Solution {
    int t[];
    int dp(int n, int keys[],  Map<Integer,Integer> mp )
    {
        if(n<0)
            return 0;
        if(n==0)
            return keys[n]*mp.get(keys[n]);
        if(t[n]!=-1)
            return t[n];
        
        int j=(keys[n-1]+1==keys[n]) ? 2 : 1;
        return t[n]=Math.max(keys[n]*mp.get(keys[n]) + dp(n-j,keys,mp) , dp(n-1,keys,mp));
    }
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num : nums)
            mp.put(num, mp.getOrDefault(num,0)+1);
        int[] keysArray = mp.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(keysArray);
        int n=keysArray.length;
        t= new int[n+1];
        for(int i=0;i<=n;i++)
        t[i]=-1; 
        return dp(keysArray.length-1, keysArray,mp);
    }
}