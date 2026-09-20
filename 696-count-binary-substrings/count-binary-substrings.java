class Solution {
    public int countBinarySubstrings(String s) {
        char ch[]=s.toCharArray();
        int prvC=0;
        char p=ch[0];
        int c=1;
        int ans=0;
        for(int i=1;i<s.length();i++)
        {
            if(p!=ch[i])
            {
                ans+=Math.min(prvC,c);
                prvC=c;
                c=1;
                p=ch[i];
            }
            else
                c++;
        }
       
        return ans+Math.min(prvC,c);
    }
}