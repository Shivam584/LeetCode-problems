class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(mp.size()==0 || mp.lastKey()<nums[i])
                mp.put(nums[i],1);
            else
            {
                mp.remove(mp.ceilingKey(nums[i]));
                mp.put(nums[i],1);
            }
        }
        return mp.size();
    }
}