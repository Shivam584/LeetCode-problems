class Solution {
    Set<String> hs;
    int t[][];
    boolean dp(char ch[], int i,int j)
    {
        if(i>j)
            return false;
        if(hs.contains(new String(ch, i, j-i+1)))
            return true;
        
        if(t[i][j]!=-1)
            return t[i][j]==1;
        boolean temp=false;
        for(int k=i;k<j;k++)
        {
            temp=temp || (dp(ch,i,k) && dp(ch,k+1,j));
        }
        t[i][j]=(temp) ? 1 : 0;
        return temp;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
         hs = new HashSet<>();
         int n=s.length();
         t=new int[n+1][n+1];
        for(String word : wordDict)
            hs.add(word);
        
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            t[i][j]=-1;
        }
        return dp(s.toCharArray(),0,n-1);
    }
}