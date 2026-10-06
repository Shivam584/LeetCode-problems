class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length,k=0;
        for(int num : nums)
            sum+=num;
            if(sum%2!=0)
                return false;
            sum/=2;
        boolean ans[][]= new boolean [2][sum+1];
        boolean temp=false;
            for(int i=0;i<=n;i++)
            {
                k= i&1;
                for(int j=0;j<=sum;j++)
                {
                    if(j==0)
                        ans[k][j]=true;
                    else if(i==0)
                        ans[k][j]=false;
                    else if(nums[i-1]<=j)
                        ans[k][j]= ans[1-k][j] || ans[1-k][j-nums[i-1]];
                    else
                        ans[k][j]=ans[1-k][j];
                }
            }
        return ans[n&1][sum];
    }
}