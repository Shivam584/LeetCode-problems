class Solution {
    public int minSubArrayLen(int target, int[] nums) {
            int i=0,j=0;
            int ans=nums.length+1,temp_sum=0;
            while(j<nums.length)
            {
                temp_sum+=nums[j];
                while(i<=j && (temp_sum-nums[i])>=target)
                {
                    temp_sum-=nums[i];
                    i++;
                }
                if(target<=temp_sum)
                    ans=Math.min(ans,j-i+1);
                j++;   
            }    
        return (ans>nums.length) ? 0 :ans;
    }
}
