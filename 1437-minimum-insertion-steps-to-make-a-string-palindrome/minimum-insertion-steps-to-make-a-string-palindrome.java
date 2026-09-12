class Solution {
   
    public int minInsertions(String s) {
        int n=s.length();
        char ch1[]= s.toCharArray();
        int t[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            for(int j=n;j>=0;j--)
                {
                    if(i==0 || j==n)
                       continue;
                t[i][j]=Math.max(t[i-1][j],t[i][j+1]);
                if(ch1[i-1]==ch1[j])
                    t[i][j]= Math.max(t[i][j],1+t[i-1][j+1]);
                   
                }
        return n-t[n][0];       
    }
}