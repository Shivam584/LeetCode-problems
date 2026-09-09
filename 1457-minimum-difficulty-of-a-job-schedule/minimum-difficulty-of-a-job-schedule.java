class Solution {
    int t[][][];
    int dp(int i,int j,int []jd,int d)
    {
         if(j-i+1<d)
            return 1000_000;   
        if(t[i][j][d]!=-1)
            return t[i][j][d];
        if(d==1)
        {
            int ans=0;
            while(i<=j)
                ans=Math.max(ans,jd[i++]);
                return ans;
        }
      
        int temp=0,ans=1000_000;
        int l=d/2;
        for(int k=i;k<j;k++)
        {
            t[i][k][l]=dp(i,k,jd,l);
            t[k+1][j][d-l]=dp(k+1,j,jd,d-l);
            temp =  t[i][k][l] + t[k+1][j][d-l];
            ans=Math.min(ans,temp);
        }
        return t[i][j][d]=ans;
    }
    public int minDifficulty(int[] jd, int d) {
        int n=jd.length;
        t= new int[n+1][n+1][d+1];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        for(int k=0;k<=d;k++)
        t[i][j][k]=-1;
        int ans=dp(0,n-1,jd,d);
        return (1000_000>ans) ? ans : -1;
    }
}