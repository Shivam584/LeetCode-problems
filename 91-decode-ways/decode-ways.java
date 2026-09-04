class Solution {
    int t[];
    int dp(String s, int i, int n)
    {
        if(i>n)
            return 1;
       if(i==n)
        return s.charAt(i-1)!='0' ? 1 : 0;
        if(t[i]!=-1)
            return t[i]; 

    int digit=s.charAt(i-1)-'0';
    int nextDigit=s.charAt(i)-'0';
    int val= digit*10+nextDigit;

    if(digit==0)
        return 0;
    
    if(val>26)
        t[i]=dp(s,i+1,n);
    else
        t[i]=dp(s,i+1,n) + dp(s,i+2,n);

    return t[i];
    }
    
    public int numDecodings(String s) {
        t= new int[s.length()+1];
        for(int i=0;i<=s.length();i++)
            t[i]=-1;
        return dp(s,1,s.length());
    }
}