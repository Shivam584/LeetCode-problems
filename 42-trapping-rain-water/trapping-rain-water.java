class Solution {
    public int trap(int[] height) {
        int i=0,j=height.length-1;
        int leftMax=Integer.MIN_VALUE;
        int rightMax=Integer.MIN_VALUE;
        int ans=0;
        while(i<=j)
        {
            if(height[i]>height[j])
            {
                rightMax=Math.max(rightMax,height[j]);
                ans+=rightMax-height[j];
                j--;
            }
            else
            {

                leftMax=Math.max(leftMax,height[i]);
                ans+=leftMax-height[i];
                i++;
            }
        }
        return ans;
    }
}