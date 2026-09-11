class Solution {
    int t[][];
    int dp(int i, int j, int nums[])
    {
        if(i==j)
            return nums[i];
        if(i>j)
            return 0;
        if(t[i][j]!=-1)
            return t[i][j];
        int ans=0,temp=0;
        for(int k=i+1;k<j;k++)
        {
            t[i][k]=dp(i,k,nums) ;
            t[k][j]=dp(k,j,nums) ;
            ans =nums[i]*nums[k]*nums[j] + t[i][k] + t[k][j];
            temp=Math.max(temp,ans);
        }
        return t[i][j]=temp;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int k[]= new int[n+2];
        k[0]=k[n+1]=1;
        for(int i=1;i<=n;i++)
            k[i]=nums[i-1];
        t= new int[n+2][n+2];
        for(int i=0;i<=n+1;i++)
        {
            for(int j=0;j<=n+1;j++)
                t[i][j]=-1;
        }
        return dp(0,n+1,k);
    }
}