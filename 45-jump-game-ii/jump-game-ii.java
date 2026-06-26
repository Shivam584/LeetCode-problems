class Solution {
    int t[];
    int dp(int[] nums, int n)
    {
        if(nums.length-1<=n)
            return 0;
        if(t[n]+1!=Integer.MAX_VALUE)
            return t[n];
        t[n]=Integer.MAX_VALUE -1;
        for(int i=n+1; i<=n+nums[n]; i++)
            t[n]=Math.min(t[n],1+dp(nums,i));
        return t[n];
    }
    public int jump(int[] nums) {
        t= new int[nums.length+1];
        for(int i=0;i<=nums.length;i++)
            t[i]=Integer.MAX_VALUE -1;
        return dp(nums,0);
    }
}