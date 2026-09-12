class Pair
{
    int a,b;
    public Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null || obj.getClass()!=getClass())
            return false;
        Pair p = (Pair)obj;
        return p==this || (p.a==this.a && p.b==this.b);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(a,b);
    }
}

class Solution {
    Map<Pair,Integer> mp;
    int dp(int i,int j,int []cuts)
    {
        int fg=0;
        int ans= Integer.MAX_VALUE;
        Pair p= new Pair(i,j);
        if(mp.containsKey(p))
            return mp.get(p);
        for(int x : cuts)
            if(i<x && x<j)
            {
                fg=1;
                ans=Math.min(ans,j-i+dp(i,x,cuts)+dp(x,j,cuts));
            }
        ans=fg==0 ? 0: ans;
        mp.put(p,ans);
        return  ans;
    }
    public int minCost(int n, int[] cuts) {
        mp= new HashMap<Pair,Integer>();
        return dp(0,n,cuts);
    }
}
