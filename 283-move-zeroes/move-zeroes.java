class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=1,n=nums.length;

        while(j<n)
        {
            while(nums[i]!=0 && i<j)
                i++;

            if(i<j && nums[j]!=0)
            {
                nums[i]=nums[j];
                nums[j]=0;
                i++;
            }
            j++;
        }
    }
}
