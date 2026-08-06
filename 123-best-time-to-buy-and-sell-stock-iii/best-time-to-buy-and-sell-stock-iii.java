class Solution {
    public int maxProfit(int[] nums) {
        int n=nums.length;
        int buy1=Integer.MAX_VALUE,
            sell1=Integer.MIN_VALUE,
            buy2=Integer.MAX_VALUE,
            sell2=Integer.MIN_VALUE;
        int profit=0;
        for(int i=0;i<n;i++)
        {
            buy1=Math.min(buy1,nums[i]);
            sell1=Math.max(sell1,nums[i]-buy1);
            buy2=Math.min(buy2,nums[i]-sell1);
            sell2=Math.max(sell2,nums[i]-buy2); 
        }
        return sell2;
    }
}
