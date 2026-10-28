class Solution {
    int t[][][];
    int dp(int i,int j,int k,char s1[],char s2[],char s3[])
    {
        if(k== 0)
            return 1;
        if(i==0 && j==0)
            return 0;
        if(t[i][j][k]!=-1)
            return t[i][j][k];
        int ans=0;
        if(i>0 && s1[i-1]==s3[k-1])
            ans=Math.max(ans,dp(i-1,j,k-1,s1,s2,s3));
        if(j>0 && s2[j-1]==s3[k-1])
            ans=Math.max(ans,dp(i,j-1,k-1,s1,s2,s3));
        if(i>0 && j>0 && s1[i-1]!=s3[k-1] && s2[j-1]!=s3[k-1])
            return 0;
        return t[i][j][k]=ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if(n3!=n1+n2)
            return false;
        t= new int[n1+1][n2+1][n3+1];
        for(int i=0;i<=n1;i++)for(int j=0;j<=n2;j++)for(int k=0;k<=n3;k++)
        t[i][j][k]=-1;
        return dp(n1,n2,n3,s1.toCharArray(),s2.toCharArray(),s3.toCharArray())==1;
    }
}