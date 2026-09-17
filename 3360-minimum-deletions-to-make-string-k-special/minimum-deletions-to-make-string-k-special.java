class Solution {
 
    public int minimumDeletions(String word, int k) {
        int c[]= new int[26];
        char ch[]= word.toCharArray();
        for(int i=0;i<ch.length;i++)   
            c[ch[i]-'a']++;
        
        Arrays.sort(c);
        int t[][]= new int[26][26];
        for(int i=24;i>-1;i--)
        {
            for(int j=i+1;j<26;j++)
            {
                if(c[j]-c[i]>k)
                {
                    int diff=c[j]-c[i]-k;
                    t[i][j]= Math.min(diff+t[i][j-1], c[i]+t[i+1][j]);
                }
            }
        }
        
        return t[0][25];
    }
}