class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer,Integer> tp= new TreeMap<>();
        tp.put(nums[0],1);
        int l=1,val=0;
        for(int i=1;i<nums.length;i++)
        {
            l=tp.lastEntry().getValue();
            Integer ck=tp.ceilingKey(nums[i]);
            if(ck!=null)
            {
                val=tp.get(ck);
                tp.remove(ck);
                tp.put(nums[i],val);
            }
            else
                tp.put(nums[i], l+1);
        }
        return tp.size();
    }
}