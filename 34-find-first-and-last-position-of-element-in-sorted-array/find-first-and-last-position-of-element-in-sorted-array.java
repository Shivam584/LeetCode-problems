class Solution {
    int findFirstPostion(int[] nums, int i,int j,int target)
    {
        int ans=-1;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]==target)
                ans=mid;

            if(nums[mid]>=target)
                j=mid-1;
            else
                i=mid+1;
        }
        return ans;
    }
    
    int findLastPostion(int[] nums, int i,int j,int target)
    {
        int ans=-1;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            if(nums[mid]==target)
                ans=mid;

            if(nums[mid]<=target)
                i=mid+1; 
            else
                j=mid-1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans =new int[2];
        ans[0]=findFirstPostion(nums,0,nums.length-1,target);
        ans[1]=findLastPostion(nums,0,nums.length-1,target);
        return ans;
    }
}