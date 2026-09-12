class Solution {
    int t[][];
    int dp(int i,int j,char ch1[],int n)
    {
        if(i==0 || j==n)
            return 0;
        if(t[i][j]!=-1)
            return t[i][j];
        int ans=Math.max(dp(i-1,j,ch1,n),dp(i,j+1,ch1,n));
        if(ch1[i-1]==ch1[j])
            ans= Math.max(ans,1+dp(i-1,j+1,ch1,n));
        return t[i][j]=ans;
    }
    public int minInsertions(String s) {
        int n=s.length();
        char ch[]= s.toCharArray();
        t=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=n;j++)
                t[i][j]=-1;
        return n-dp(n,0,s.toCharArray(),n);       
    }
}