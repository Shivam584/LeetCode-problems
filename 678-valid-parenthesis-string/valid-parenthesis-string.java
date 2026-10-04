class Solution {
    int t[][];
    boolean dp(char ch[],int i,int n,int c)
    {
        if(i>=n)
            return c==0;
        if(t[i][c]!=-1)
            return t[i][c]==1;

        boolean ans;
        if(ch[i]=='(')
            ans=dp(ch,i+1,n,c+1);
        else if(ch[i]==')')
            ans= (c>0) ? dp(ch,i+1,n,c-1) : false;
        else
        ans= dp(ch,i+1,n,c+1) || (c>0 && dp(ch,i+1,n,c-1)) || dp(ch,i+1,n,c);           
         
        t[i][c]=ans ? 1: 0;
        return ans;
    }
    public boolean checkValidString(String s) {
        int n=s.length();
        t=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        for(int j=0;j<=n;j++)
            t[i][j]=-1;
     return dp(s.toCharArray(),0,s.length(),0);
    }
}