class Solution {
    int t[][];
    int dp(int i,int n,int []jd,int d)
    {
         if(n-i<d)
            return 1000_000;   
        if(t[i][d]!=-1)
            return t[i][d];
        if(d==1)
        {
            int ans=0;
            while(i<n)
                ans=Math.max(ans,jd[i++]);
                return ans;
        }
      
        int temp=0,ans=1000_000;
        int mx=jd[i];
        for(int k=i;k<n;k++)
        {
            mx=Math.max(mx,jd[k]);
            temp = dp(k+1,n,jd,d-1)+mx;
            ans=Math.min(ans,temp);
        }
        return t[i][d]=ans;
    }
    public int minDifficulty(int[] jd, int d) {
        int n=jd.length;
        t= new int[n+1][d+1];
        for(int i=0;i<=n;i++)
        for(int k=0;k<=d;k++)
        t[i][k]=-1;
        int ans=dp(0,n,jd,d);
        return (1000_000>ans) ? ans : -1;
    }
}