class Solution {
    int t[][];
    boolean dp(int i,int p,int n, int s[], Map<Integer,Integer> mp)
    {
        if(i==n-1)
            return true;
        
        boolean ans=false;

        if(t[i][p]!=-1)
            return t[i][p]==1;
        int diff=s[i]-s[p]-1;
            for(int l=0;l<3;l++)
            {
                Integer x= mp.get(s[i]+diff+l);
                if(x!=null && x!=i)
                    ans=ans || dp(x,i,n,s,mp);
            }
        t[i][p]= ans? 1: 0;
        return ans;
    }
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if((stones[n-1]>stones[0] + (((n-1)*n)/2)) || (stones[1]-stones[0]!=1))
            return false;
        Map<Integer,Integer> s = new HashMap<>();
        for(int i=0;i<n;i++)
            s.put(stones[i],i);

        t= new int [n+1][n+1];

        for(int i=0;i<=n;i++)
            for(int j=0;j<=n;j++)
                t[i][j]=-1;
        return dp(1,0,stones.length,stones,s);
    }
}