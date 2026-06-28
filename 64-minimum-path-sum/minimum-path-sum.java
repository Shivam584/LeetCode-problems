class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int dp[][]= new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i==1&&j==1)
                    dp[i][j]=grid[0][0];
                else if(j==1)
                    dp[i][j]=grid[i-1][j-1]+dp[i-1][j];
                else if(i==1)
                    dp[i][j]=grid[i-1][j-1]+dp[i][j-1];
                else
                    dp[i][j]=grid[i-1][j-1]+Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
}