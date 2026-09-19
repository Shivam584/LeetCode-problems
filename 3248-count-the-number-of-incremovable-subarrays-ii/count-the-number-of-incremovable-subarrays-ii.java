class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n=nums.length;
        int l=1,j=n-1;
        while(l<n && nums[l]>nums[l-1])
        l++;
        while(j>0 && nums[j]>nums[j-1])
            j--;
        if(j==0)
            return (n*(n+1l))/2l;
        long ans=n-j+1;
        for(int i=0;i<l;i++)
        {
            while(j<n && nums[i]>=nums[j])
                j++;
            ans+=n+1-j;
        }
        return ans;
    }
}