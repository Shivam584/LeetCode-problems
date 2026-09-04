class Solution {
    
    public int maxProfit(int k, int[] nums) {
        int n=nums.length;

        int temp=0;
        int b[] =new int[k];
        int s[] =new int[k];

        for(int i=0;i<k;i++)
        {
            b[i]=Integer.MIN_VALUE;
            s[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<n;i++)
        {
            temp=0;
            for(int j=0;j<k;j++)
            {
                b[j]=Math.max(b[j],temp-nums[i]);
                s[j]=Math.max(s[j],nums[i]+b[j]);
                temp=s[j];
            }
        }
        return s[k-1];
    }
}
