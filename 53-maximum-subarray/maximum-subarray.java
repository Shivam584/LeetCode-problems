class Solution {
    public int maxSubArray(int[] nums) {
        int temp=nums[0],ans=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            temp=nums[i]+Math.max(temp,0);
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}