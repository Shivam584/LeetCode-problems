class Solution {
    
    public int maxProfit(int[] nums) {
        int n=nums.length;
        int b1=Integer.MIN_VALUE;
        int b2=Integer.MIN_VALUE;
        int s1=Integer.MIN_VALUE;
        int s2=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            b1=Math.max(b1,-nums[i]);
            s1=Math.max(s1,nums[i]+b1);
            b2=Math.max(b2,s1-nums[i]);
            s2=Math.max(s2,nums[i]+b2);
        }
        return s2;
    }
}
