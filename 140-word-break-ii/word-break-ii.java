class Solution {
    StringBuilder s0;
    void dp(char ch[], int i,int n,List<String> ls, Set<String> hs)
    {
        if(i>=n)
            {
                if(s0.isEmpty())
                    return;
                else
                ls.add(s0.toString());
            }
        for(int j=i;j<n;j++)
        {
            String s1= new String(ch,i, j-i+1);
            int len=j-i+1;
            if(hs.contains(s1))
            {        
                s0.append(s1);
                if(j!=n-1)
                    {s0.append(' ');len++;}
                dp(ch,j+1,n,ls,hs);
                s0.delete(s0.length() -len, s0.length());
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        s0= new StringBuilder();
        char ch[]=s.toCharArray();
        Set<String> hs = new HashSet<>();
        for(String w : wordDict)
            hs.add(w);
        List<String> ls= new ArrayList<>();
        dp(ch,0,s.length(),ls,hs);
        return ls;
    }
}