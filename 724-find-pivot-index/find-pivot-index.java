class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int preSumL[] =new int[n];
        int preSumR[] =new int[n];
        preSumL[0]=nums[0];
        preSumR[n-1]=nums[n-1];
        for(int i=1,j=n-2;i<n;i++,j--)
        {
            preSumL[i]=nums[i]+preSumL[i-1];
            preSumR[j]=nums[j]+preSumR[j+1];
       
        }
        if(preSumR[0]==nums[0])
            return 0;
        for(int i=1;i<n;i++)
        {
            if(preSumL[i]==preSumR[i])
            return i;
        }
        if(preSumL[n-1]==nums[n-1])
            return n-1;
        return -1;
    }
}