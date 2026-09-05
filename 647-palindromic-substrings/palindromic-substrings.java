class Solution {
    int count(int i,int j,String s)
    {
        int c=0;
        while(i>-1 && j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
                c++;
            else 
                break;
            i--;j++;
        }
        return c;
    }
    public int countSubstrings(String s) {
        int n=s.length(), ans=0;
        for(int i=0;i<n;i++)
            ans+=count(i,i,s)+count(i,i+1,s);
        return ans;
    }
}