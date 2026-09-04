class Solution {
    int t[][];
    int dp(int c[], int n,int amt)
    {
        if(amt==0)
        return 0;
        if(n<0)
        return 1000_000;
        if(t[n][amt]!=-1)
            return t[n][amt];
        if(amt>=c[n])
            t[n][amt]=Math.min(1+dp(c,n,amt-c[n]), dp(c,n-1,amt));
        else
            t[n][amt]= dp(c,n-1,amt);
        return t[n][amt];
    }
    public int coinChange(int[] coins, int amount) {
        t= new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++)
            for(int j=0;j<=amount;j++)
                t[i][j]=-1;
        int ans=dp(coins,coins.length-1,amount);
        return (ans==1000_000) ? -1 : ans;
    }
}