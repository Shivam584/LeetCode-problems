class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int preSumL=0;
        int preSumR =0;
        for(int i=0;i<n;i++)
            preSumR+=nums[i];
        for(int i=0;i<n;i++)
        {
            preSumR-=nums[i];
           if(preSumL==preSumR)
            return i;
           preSumL+=nums[i];
            
        }
     return -1;
    }
}