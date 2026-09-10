class Solution {
    int t[][][];
    int dp(int i,int n, int p[],int k,boolean hold)
    {
        if(k==0)
            return 0;
        if(i==n-1)
            return (hold) ? p[n-1] : 0;
        int l=hold? 1: 0;
        if(t[i][k][l]!=-1)
            return t[i][k][l];
        if(hold)
            return t[i][k][1]=Math.max(p[i]+dp(i+1,n,p,k-1,false),dp(i+1,n,p,k,hold));
        
        return t[i][k][0]=Math.max(-p[i]+dp(i+1,n,p,k,true),dp(i+1,n,p,k,hold));
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
       t= new int [n][k+1][2];
       for(int i=0;i<n;i++)
       for(int j=0;j<=k;j++)
        t[i][j][0]=t[i][j][1]=-1;
       return dp(0,n,prices,k,false);
    }
}