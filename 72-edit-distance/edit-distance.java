class Solution {
    
    public int minDistance(String word1, String word2) {
        int t[][]= new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++)
        for(int j=0;j<=word2.length();j++)
            {
                if(i==0)
                    t[i][j]=j;
                else if(j==0)
                    t[i][j]=i;
                else
                {
                    t[i][j]=t[i-1][j-1];
                    if(word1.charAt(i-1) != word2.charAt(j-1))
                    t[i][j]=1+Math.min(t[i][j],Math.min(t[i][j-1],t[i-1][j]));
                }
            }
        return t[word1.length()][word2.length()];
    }
}