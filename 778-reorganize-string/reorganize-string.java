class Solution {
    public String reorganizeString(String s) {
        char ch[]= s.toCharArray();
        char ans[]= new char[s.length()];
        int c[]= new int[26];
        List<int []> ls = new ArrayList<>(); 
        for(char x: ch)
            c[x-'a']++; 
        for(int i=0;i<=25;i++)
            if(c[i]>0)
                ls.add(new int[]{c[i],i});
                
        int l=0;
        Collections.sort(ls,(a,b)->{
            return Integer.compare(b[0],a[0]);
        });
        for(int i=0;i<ls.size();i++)
        {
            int cur[]=ls.get(i);
            char x=(char)('a'+cur[1]);
            for(int j=0;j<cur[0];j++)
            {
                ans[l]=x;
                l+=2;
                if(l>=s.length() && l%2==0)
                    l=1;
            }
        }
        for(int i=0;i<s.length()-1;i++)
            if(ans[i]==ans[i+1])
                return "";
        return new String(ans);
    }
}