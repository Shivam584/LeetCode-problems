class Solution {
    int ts[][];
    public int dp(int i,int j,String s,String t)
    {
        if(j==0)
        return 1;
        if(i==0 || j==0)
        return 0;
        if(ts[i][j]!=-1)
        return ts[i][j];
        if(s.charAt(i-1)==t.charAt(j-1))
            return ts[i][j]=dp(i-1,j-1,s,t) +dp(i-1,j,s,t);
        return ts[i][j]=dp(i-1,j,s,t);
    }
    public int numDistinct(String s, String t) {
        ts=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++)
        {
            for(int j=0;j<=t.length();j++)
            ts[i][j]=-1;
        }
        return dp(s.length(),t.length(),s,t);
    }
}