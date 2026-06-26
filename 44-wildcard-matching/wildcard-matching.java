class Pairs{
    int a,b;

    Pairs(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        return true;
        if(!(obj instanceof Pairs))
        return false;
        Pairs B = (Pairs)obj;
        return this.a == B.a && this.b == B.b;
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
class Solution {
    Map<Pairs,Boolean> mp;
    boolean dp(String s,String p,int n,int m)
    {
        if(m<=0)
            return n<=0;
        Pairs P =new Pairs(n,m);
        if(mp.containsKey(P))
            return mp.get(P);

        Boolean result=false;
        if(p.charAt(m-1)=='*')
                {
                    result=dp(s,p,n-1,m-1)|| dp(s,p,n,m-1);
                    if(n>0)
                    result = result || dp(s,p,n-1,m);
                }
        else if(n>0)
            result=(p.charAt(m-1)=='?' || p.charAt(m-1)==s.charAt(n-1)) && dp(s,p,n-1,m-1);
        mp.put(P,result);
    return result;
    }
    public boolean isMatch(String s, String p) {
        mp =new HashMap<>();
        return dp(s,p, s.length(),p.length());
    }
}