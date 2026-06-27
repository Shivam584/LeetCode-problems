class Solution {
    public boolean canJump(int[] nums) {
        int far=0,end=0;
        for(int i=0;i<nums.length-1;i++)
        {
            far= Math.max(i+nums[i],far);
            if(i==end)
            {
                if(i>=far)
                return false;
                end=far;
            }
        }
        return true;
    }
}