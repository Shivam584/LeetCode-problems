class Solution {
    int maxLen;
    Map<Integer,List<String>> mp;
    List<String> dp(char ch[], int i,int n, Set<String> hs)
    {
        if(i>=n)
                return List.of("");

        if(mp.containsKey(i))
            return mp.get(i);
        
        List<String> ans = new ArrayList<String>();
        for(int j=1;j<=maxLen && (i+j)<=n ; j++)
        {
            String s1= new String(ch,i, j);
            if(hs.contains(s1))
            {        
                List<String> sufixs= dp(ch,i+j,n,hs);   
                for(String s : sufixs)
                {
                    if(s.isEmpty())
                        ans.add(s1);
                    else
                        ans.add(s1+" "+s);
                }
            }
        }
        mp.put(i,ans);
        return ans;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        char ch[]=s.toCharArray();
        mp= new HashMap<Integer,List<String>>();
        Set<String> hs = new HashSet<>();
        for(String w : wordDict)
            {hs.add(w);maxLen= Math.max(maxLen,w.length());}
        return dp(ch,0,s.length(),hs);
    }
}