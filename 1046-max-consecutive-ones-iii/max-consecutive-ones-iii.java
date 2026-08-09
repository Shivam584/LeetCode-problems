class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,t=0,ans=0;
        while(j<nums.length)
        {
            if(nums[j]==0)
                t++;
            
            while(t>k && i<=j)
            {
                if(nums[i]==0)
                    t--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}