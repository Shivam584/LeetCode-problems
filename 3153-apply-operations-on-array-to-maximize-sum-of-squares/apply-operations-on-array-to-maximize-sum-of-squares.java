class Solution {
    public int maxSum(List<Integer> nums, int k) {
    Map<Integer,Integer> mp = new HashMap<>();
    for(int num : nums )
    {
        int i=0;
        while(num>0)
        {
            mp.put(i,mp.getOrDefault(i,0)+num % 2);
            num=num>>1;
            i++;
        }
    }
    int sum=0;
    int mod=1_000_000_007;
    while(k>0)
    {
        long x=0;
        for(Map.Entry<Integer,Integer> entry : mp.entrySet())
            {
               if(entry.getValue()>0)
               {
                    x+=Math.pow(2,entry.getKey());
                    mp.put(entry.getKey(),entry.getValue()-1);
               }    
            }
            sum=(int)(sum+(x*x)%mod)%mod;
            k--;
    }        
    
    return sum;
    }
}
