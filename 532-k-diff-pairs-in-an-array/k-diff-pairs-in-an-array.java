class Solution {
    public int findPairs(int[] nums, int k) {
       Map<Integer,Integer> mp= new HashMap<>();
       int c=0;
        if(k==0)
        {
             for(int num : nums)
                mp.put(num, mp.getOrDefault(num,0)+1);
            for(int x : mp.values())
                c=(x>1) ? c+1 : c;
            return c;
        }
        for(int num : nums)
        if(!mp.containsKey(num))
        {
            if(mp.containsKey(num-k))
            c++;
            if(k!=0 && mp.containsKey(num+k))
            c++;
            mp.put(num, mp.getOrDefault(num,0)+1);
        } 
      
       return c;
    }
}