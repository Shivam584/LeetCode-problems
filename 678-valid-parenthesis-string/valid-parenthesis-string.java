class Solution {
    int t[][][];
    boolean dp(char ch[],int i,int n,int o,int c)
    {
        if(i>=n)
            return o==c;

        if(t[i][o][c]!=-1)
            return t[i][o][c]==1;

        boolean ans=false;
        if(ch[i]=='(')
            ans=dp(ch,i+1,n,o+1,c);
        else if(ch[i]==')')
            ans= (o>c) ? dp(ch,i+1,n,o,c+1) : false;
        else
        ans= dp(ch,i+1,n,o+1,c) || (o>c && dp(ch,i+1,n,o,c+1)) || dp(ch,i+1,n,o,c);           
         
        t[i][o][c]=ans ? 1: 0;
        return ans;
    }
    public boolean checkValidString(String s) {
        int n=s.length();
        t=new int[n+1][n+1][n+1];
        for(int i=0;i<=n;i++)
        for(int j=0;j<=n;j++)
        for(int k=0;k<=n;k++)
            t[i][j][k]=-1;
     return dp(s.toCharArray(),0,s.length(),0,0);
    }
}