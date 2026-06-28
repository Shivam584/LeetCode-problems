class Solution {
   
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int dp[][]= new int[2][n+1];
        for(int i=1;i<=m;i++)
        for(int j=1;j<=n;j++)
        if(obstacleGrid[i-1][j-1]==1)
            dp[i%2][j]= 0;
            else if(i==1 && j==1)
            dp[i%2][j]= 1;
            else if(i==1)
                dp[i%2][j]= dp[i%2][j-1];
            else if(j==1)
                dp[i%2][j]=dp[(i+1)%2][j];
            else
            dp[i%2][j]=dp[(i+1)%2][j]+dp[i%2][j-1];
    return dp[m%2][n];
    }
}