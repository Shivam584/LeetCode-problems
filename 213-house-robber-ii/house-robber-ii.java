class Pair
{
    int a,b;
     Pair(int a,int b)
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
        return p.a==this.a && this.b==p.b;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(a,b);
    }
}
class Solution {
    Map<Pair,Integer> mp;
    int dp(int nums[],int i,int n)
    {
        if(i>n)
            return 0;
        Pair p=new Pair(i,n);
        if(mp.containsKey(p))
            return mp.get(p);
        int res=Math.max(nums[i-1]+dp(nums,i+2,n),dp(nums,i+1,n));
        mp.put(p,res);
        return res;
    }
    public int rob(int[] nums) {
        mp=new HashMap<Pair,Integer>();
        int n=nums.length;
        if(n<2)
            return Math.max(nums[0],nums[n-1]);
        int c1=dp(nums,1,n-1);
        mp.clear();
        int c2=dp(nums,2,n);
        return Math.max(c1,c2);
    }
}
