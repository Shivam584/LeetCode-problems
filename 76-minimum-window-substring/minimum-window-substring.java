class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        int i=0,j=0,c=0,l=0,n=s.length(),ans=s.length()+1;
        for( int k=0;k<t.length();k++)
        {
            c=mp.getOrDefault(t.charAt(k),0);
            if(c==0)
                l++;
            mp.put(t.charAt(k),c + 1);
        }
        int st=0,f;
        while(j<n)
        {
            if(mp.containsKey(s.charAt(j)))
            {
                f=mp.get(s.charAt(j));
                mp.put(s.charAt(j), f-1);
                if(f==1)
                    l--;
            }
            while(i<j && (!mp.containsKey(s.charAt(i)) || mp.getOrDefault(s.charAt(i),0)<0))
            {
                if(mp.containsKey(s.charAt(i)))
                {
                    f=mp.get(s.charAt(i));
                    mp.put(s.charAt(i),f + 1);
                    
                    if(f==0)
                        l++;
                }
                i++;     
            }

            if(l==0 && ans>(j-i+1))
            {
                st=i;
                ans=j-i+1;
            }
            j++;
        }
        if(ans>s.length())
        return "";
        return s.substring(st,st+ans);
    }
}