class Solution {
    public int findMin(int[] nums) {
        int i=0,j=nums.length-1,mid=0;
        while(i<=j)
        {
            mid=i+(j-i)/2;
            if((mid==0 || nums[mid-1]>nums[mid]) && (mid+1==nums.length || nums[mid+1]>nums[mid]))
            break;
            else if(nums[j]>nums[mid])
            j=mid-1;
            else
            i=mid+1;
        }
        return nums[mid];
    }
}