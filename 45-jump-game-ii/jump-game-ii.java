class Solution {
    public int jump(int[] nums) {
        int ans=0, end=0,far=0;
        for(int i=0;i<nums.length-1;i++)
        {
            far= Math.max(i+nums[i],far);
            if(i==end)
            {
                ans++;
                end=far;
            }
        }
        return ans;
    }
}