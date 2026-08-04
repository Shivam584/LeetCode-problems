class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp =new HashMap<>();
        int k=0;
        int ans[]= new int[2];
        for(int i=0;i<nums.length;i++)
            {
                if(2*nums[i]==target)
                    {
                        ans[(k++)%2]=i;
                    }
                else
                    mp.put(nums[i],i);
            }
        if(k==2)
            return ans;
        for(int i=0;i<nums.length;i++)
        {
            if(mp.containsKey(target-nums[i]))
            {
                ans[0]=i;
                ans[1]=mp.get(target-nums[i]);
                break;
            }
        }
        return ans;
    }
}