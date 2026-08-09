class Solution {
    public int longestSubstring(String s, int k) {
       int n=s.length();
       int ans=0;
       char ch[] = s.toCharArray();
       int maxC=0;
       Set<Character> ms= new HashSet<>();
       for(char c : ch)
            ms.add(c);
        maxC=ms.size();

       for(int l=1;l<=maxC;l++)
       {
            int i=0,j=0,p=0;
            Map<Character,Integer> mp =new HashMap<>();
            while(j<n)
            {
                mp.put(ch[j],mp.getOrDefault(ch[j],0)+1);
                if(mp.get(ch[j])==1)
                    p++;
                
                while(p>l && i<=j)
                {
                    if(mp.get(ch[i])==1)
                        {
                            p--;
                            mp.remove(ch[i]);
                        }
                    else
                        mp.put(ch[i],mp.get(ch[i])-1);
                    i++;
                }
                boolean fg=true;
                for(int v: mp.values())
                {
                    if(v<k)
                        fg=false;
                }
                if(fg)
                ans=Math.max(ans,j-i+1);
                j++;
            }
       }
        return ans;
    }
}


