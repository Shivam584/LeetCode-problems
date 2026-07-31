class Solution {
    int search(int[] nums, int i,int j,int target)
    {
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(nums[mid]==target)
            return mid;
            else if(nums[mid]<target)
            i=mid+1;
            else
            j=mid-1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int startIndex=0;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if((mid==0 || nums[mid-1]>nums[mid]) && (mid+1==nums.length || nums[mid+1]>nums[mid]))
            {
                startIndex=mid;
                break;
            }
            else if (nums[j]>nums[mid])
            j=mid-1;
            else
            i=mid+1;
        }
        // System.out.println(startIndex);
        return Math.max(search(nums,0,startIndex-1, target),
         search(nums,startIndex,nums.length-1,target));
    }
}