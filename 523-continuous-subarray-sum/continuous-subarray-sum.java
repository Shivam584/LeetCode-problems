class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       int n=nums.length;
       for(int i=0;i<n;i++)
            nums[i]=nums[i]%k;
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
       int sum=0,ans=0;
       mp.put(0,-1);
       for(int i=0;i<n;i++)
       {
            sum=(sum+nums[i])%k;
            if(mp.containsKey(sum)){
                    ans=Math.max(ans,i-mp.get(sum));
                    if(ans>1)
                    return true;
                }
            else
                mp.put(sum,i);
       } 
       return false;
    }
}