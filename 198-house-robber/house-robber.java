class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<2)
            return nums[0];
        int dp[]= new int[3];
        dp[1]=nums[0];
        dp[2]=Math.max(nums[0],nums[1]);
        for(int i=3;i<=n;i++)
            {
                dp[i%3]=Math.max(dp[(i-2)%3]+nums[i-1], dp[(i-1)%3]);
            }
        return dp[n%3];
    }
}