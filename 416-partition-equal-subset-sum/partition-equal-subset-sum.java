class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num : nums)
            sum+=num;
            if(sum%2!=0)
                return false;
            sum/=2;
        boolean ans[][]= new boolean [n+1][sum+1];
            for(int i=0;i<=n;i++)
            {
                for(int j=0;j<=sum;j++)
                {
                    if(j==0)
                        ans[i][j]=true;
                    else if(i==0)
                        ans[i][j]=false;
                    else if(nums[i-1]<=j)
                        ans[i][j]= ans[i-1][j] || ans[i-1][j-nums[i-1]];
                    else
                        ans[i][j]=ans[i-1][j];
                }
            }
        return ans[n][sum];
    }
}