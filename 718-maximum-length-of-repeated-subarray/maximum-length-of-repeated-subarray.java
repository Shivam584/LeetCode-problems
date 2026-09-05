class Solution {
 
    public int findLength(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int dp[][]= new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++)
        for(int j=0;j<=n2;j++)
        { 
            if(i==0 || j==0)
                dp[i][j]=0;
            else
            {
                if(nums1[i-1]==nums2[j-1])
                    {
                    dp[i][j]=1+dp[i-1][j-1];
                    // dp[i][j]=Math.max(dp[i][j],Math.max(dp[i][j-1],dp[i-1][j]));
                    }
                else
                    dp[i][j]=0;
            }
        }
        for(int i=0;i<=n1;i++)
        for(int j=0;j<=n2;j++)
            dp[n1][n2]=Math.max(dp[n1][n2],dp[i][j]);
        return dp[n1][n2];
    }
}