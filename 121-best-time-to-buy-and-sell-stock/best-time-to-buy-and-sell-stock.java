class Index
{
    int i,fg,k;
    public Index(int i,int fg, int k)
    {
        this.i=i;
        this.fg=fg;
        this.k=k;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null || obj.getClass()!=getClass())
            return false;
        Index ip=(Index)obj;
        return obj==ip || (this.i==ip.i && this.fg==ip.fg && this.k==ip.k );
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(i,fg,k);
    }
}
class Solution {
    Map<Index,Integer> mp;
    int dp(int i, int sz, int[] prices,int fg,int k)
    {
        if(k==0)
            return 0;
        if(i==sz)
            return (fg==1) ? prices[i-1] : 0;
        Index ip= new Index(i,fg,k);
        Integer val=mp.get(ip);
        if(val!=null)
            return val;
        int transaction=prices[i-1];
        if(fg==0)
            transaction*=-1;     
        val=Math.max(transaction+dp(i+1,sz,prices,1-fg,(fg==1)? k-1: k),dp(i+1,sz,prices,fg,k));
        mp.put(ip,val);
        return val;
    }
    public int maxProfit(int[] prices) {
        mp= new HashMap<Index,Integer>();
        return dp(1,prices.length, prices,0,1);
    }
}