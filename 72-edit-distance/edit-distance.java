class Solution {
    int t[][];
    int dp(String word1, String word2,int a,int b)
    {
        if(b==0)
            return a;
        if(a==0)
            return b;
        if(t[a][b]==-1)
        {
            if(word1.charAt(a-1) == word2.charAt(b-1))
                t[a][b]= dp(word1,word2,a-1,b-1);
            else
            t[a][b]=1+Math.min(dp(word1,word2,a-1,b-1),Math.min(dp(word1,word2,a-1,b),dp(word1,word2,a,b-1)));
       
        }
        return t[a][b];
    }
    public int minDistance(String word1, String word2) {
        t= new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++)
        for(int j=0;j<=word2.length();j++)
            t[i][j]=-1;
        return dp(word1,word2,word1.length(),word2.length());
    }
}