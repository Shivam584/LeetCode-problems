class Solution {
    public int findPeakElement(int[] nums) {
        int i=0,j=nums.length-1;
        int mid=0;
        while(i<=j)
        {
            mid=i+(j-i)/2;
            if((mid==0 || nums[mid-1]<nums[mid]) && (mid+1==nums.length || nums[mid+1]<nums[mid]))
            break;
            else if(mid+1==nums.length || nums[mid+1]>nums[mid])
            i=mid+1;
            else
            j=mid-1;
        }
        return mid;
    }
}