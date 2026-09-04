class Solution {

    public boolean divisorGame(int n) {
        
        int dp[]= new int[n+1];
        
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=i/2;j++)
                    dp[i]=Math.max(dp[i],dp[i-j]+1);
        }
        return dp[n]%2==1;
    }
}
