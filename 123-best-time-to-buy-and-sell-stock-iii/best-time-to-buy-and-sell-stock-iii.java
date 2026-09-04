class Solution {
    
    public int maxProfit(int[] nums) {
        int n=nums.length;

        int temp=0;
        int b[]= new int[2];
        int s[]= new int[2];

        for(int i=0;i<2;i++)
        {
            b[i]=Integer.MIN_VALUE;
            s[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<n;i++)
        {
            temp=0;
            for(int j=0;j<2;j++)
            {
                b[j]=Math.max(b[j],temp-nums[i]);
                s[j]=Math.max(s[j],nums[i]+b[j]);
                temp=s[j];
            }
        }
        return s[1];
    }
}
