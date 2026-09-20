class Solution {
    public int countBinarySubstrings(String s) {
        int prvC=0;
        char p=s.charAt(0);
        int c=1;
        int ans=0;
        for(int i=1;i<s.length();i++)
        {
            if(p!=s.charAt(i))
            {
                ans+=Math.min(prvC,c);
                prvC=c;
                c=1;
                p=s.charAt(i);
            }
            else
                c++;
        }
       
        return ans+Math.min(prvC,c);
    }
}