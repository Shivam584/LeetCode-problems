class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> mp = new HashMap<>();
        int l=0,f=0;
        for(int k=0;k<s1.length();k++)
        {
            f=mp.getOrDefault(s1.charAt(k),0);
            mp.put(s1.charAt(k),f+1);
            if(f==0)
            l++;
        }
    int i=0,j=0,n=s2.length();
        while(j<n)
        {
            if(mp.containsKey(s2.charAt(j)))
            {
                f=mp.get(s2.charAt(j));
                mp.put(s2.charAt(j),f-1);
                if(f==1)
                    l--;
            }
            if(j-i+1==s1.length())
            {
                if(l==0)
                return true;

                if(mp.containsKey(s2.charAt(i)))
                {
                    f=mp.get(s2.charAt(i));
                    mp.put(s2.charAt(i),f+1);
                    if(f==0)
                        l++;
                }
                i++;
            }
            j++;
        }
        return false;
    }
}