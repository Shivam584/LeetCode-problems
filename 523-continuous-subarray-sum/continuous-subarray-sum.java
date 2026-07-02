class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            sum=sum%k;
            if(mp.containsKey(sum))
            {
            if(i-mp.get(sum)>1)
                return true;
            }
            else
            mp.put(sum,i);
        }
        return false;
    }
}