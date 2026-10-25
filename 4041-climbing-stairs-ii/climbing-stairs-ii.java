class Solution {
    // int dp(int n,int costs[])
    // {
    //     if(n==0)
    //         return 0;
    //     int a=dp(n-1,costs)+1;
    //     if(n==1)
    //         return costs[n-1]+a;
    //     int b=dp(n-2,costs)+4;
    //     if(n==2)
    //         return costs[n-1]+Math.min(a,b);
    //     int c=dp(n-3,costs)+9;

    //     return costs[n-1]+Math.min(a,Math.min(b,c));  
    // }
    public int climbStairs(int n, int[] costs) {
            int t[]= new int[n+1];
            t[0]=0;
            t[1]=costs[0]+1;
            if(n==1)
                return t[1];
            t[2]=costs[1]+Math.min(t[1]+1,t[0]+4);
            if(n==2)
                return t[2];
            for(int i=3;i<=n;i++)
                t[i]=costs[i-1]+Math.min(t[i-1]+1,Math.min(t[i-2]+4,t[i-3]+9));
            return t[n];
    }
}