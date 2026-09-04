class Solution {
    Set<String> hs;
    int t[];
    boolean dp(char ch[], int n)
    {
        if(n<=0)
            return true;
       
        if(t[n]!=-1)
            return t[n]==1;

        boolean temp=false;
        int k=1;   
        while(k<=n)
        {
            if(hs.contains(new String(ch,k-1,n-k+1)))
                {
                    if(dp(ch,k-1))
                          {temp=true;break;}
                }
            k++;
        }
      
        t[n]=(temp) ? 1 : 0;
        return temp;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
         hs = new HashSet<>();
         int n=s.length();
         t=new int[n+1];

        for(String word : wordDict)
            hs.add(word);
        
            for(int j=0;j<=n;j++)
            t[j]=-1;
    
        return dp(s.toCharArray(),n);
    }
}