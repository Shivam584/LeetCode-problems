class Solution {
    int t[][];
    int dp(int i,int j,char w1[],char w2[])
    {
        if(i==0 & j==0)
            return 0;
        if(j==0)
            return i;
        if(i==0)
            return j;
        if(t[i][j]!=-1)
            return t[i][j];
        int cost=1+dp(i-1,j-1,w1,w2);
        if(w1[i-1]==w2[j-1])
            cost--;
        return t[i][j]=Math.min(cost,1+Math.min(cost,Math.min(dp(i-1,j,w1,w2),dp(i,j-1,w1,w2))));
    }
    public int minDistance(String word1, String word2) {
        int w1=word1.length(),w2=word2.length();
        t= new int[w1+1][w2+1];
        for(int i=0;i<=w1;i++)
            for(int j=0;j<=w2;j++)
                t[i][j]=-1;
        return dp(w1,w2,word1.toCharArray(),word2.toCharArray());
    }
}