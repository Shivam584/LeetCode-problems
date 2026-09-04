class Solution {
    int t[][];
    int dp(int i,int n,int[] prices,int h)
    {
        if(i>=n)
            return (h==1) ? prices[i-1] : 0;
        if(t[i][h]!=-1)
            return t[i][h];
        int skip=dp(i+1,n,prices,h);
        if(h==1)
            t[i][h]= Math.max(skip, prices[i-1]+dp(i+2,n,prices,1-h));
        else
            t[i][h]=Math.max(skip, -prices[i-1]+dp(i+1,n,prices,1-h));

    return t[i][h];
    }
    public int maxProfit(int[] prices) {
        t = new int[prices.length+1][2];
        for(int i=0;i<=prices.length;i++)
           t[i][0]=t[i][1]=-1;
         return dp(1,prices.length,prices,0);
    }
}