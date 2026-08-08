class Solution {
    int t[][][];
    int dp(int[] nums, int i,int n, int k, int h)
    {
        if((k==0 || i==n) && h==0)
            return 0;
        if((k==0 || i==n) && h==1)
            return Integer.MIN_VALUE;
        
        if(t[i][k][h]!=-1)
            return t[i][k][h];

    int ans= dp(nums,i+1,n,k,h);
        if(h==0)
        {
            ans=Math.max(-nums[i]+dp(nums,i,n,k,1),ans);
        }
        else
        {
            ans=Math.max(nums[i]+dp(nums,i,n,k-1,0),ans);
        }
        return t[i][k][h]=ans;
    }
    public int maxProfit(int[] nums) {
        int n=nums.length;
        t=new int[n+1][3][3];
        
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    t[i][j][k]=-1;
                }
            }
        }
        return dp(nums, 0,n,2, 0);
    }
}
