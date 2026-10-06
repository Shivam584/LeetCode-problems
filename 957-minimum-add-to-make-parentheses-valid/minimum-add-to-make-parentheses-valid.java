class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        char ch[]= s.toCharArray();
        int ans=0,c=0;
        for(int i=0;i<n;i++)
        {
            if(ch[i]=='(')
                c++;
            else
                {
                    if(c==0)
                    ans++;
                    else
                    c--;
                }
        }
        return ans+c;
    }
}