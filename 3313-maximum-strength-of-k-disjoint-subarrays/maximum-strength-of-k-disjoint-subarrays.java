class Solution {
    long t[][][];
    long NEG= Long.MIN_VALUE/4;
     long dp( int i,int n, int k, int fg, int nums[])
     {
        
        if(k==0)
            return 0;
        
        if(k>n || i==n)
         return NEG;
        if(t[i][k][fg]!=NEG)
            return t[i][k][fg];
        long k1=(long)k;
        t[i][k][fg]= ((k%2==1) ? k1*nums[i]: -k1*nums[i]) + Math.max(dp(i+1,n,k,1,nums),
        dp(i+1,n,k-1,1,nums));

        if(fg==0)
            t[i][k][fg]=Math.max(dp(i+1,n,k,0,nums),t[i][k][fg]);

        return t[i][k][fg];
     }
    public long maximumStrength(int[] nums, int k) {
        int n=nums.length;
        t= new long [n][k+1][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<=k;j++)
                t[i][j][0]=t[i][j][1]=NEG;
        return dp(0,n,k,0,nums);
    }
}