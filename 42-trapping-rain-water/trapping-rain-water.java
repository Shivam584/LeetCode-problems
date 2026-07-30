class Solution {
    public int trap(int[] height) {
        int i=0,j=height.length-1;
        int lMax=0,rMax=0;
        int trappedWater=0;
        while(i<j)
        {
            if(height[i]<height[j])
            {
                lMax=Math.max(lMax,height[i]);
                trappedWater+=lMax-height[i];
                i++;
            }
            else
            {
                rMax=Math.max(rMax,height[j]);
                trappedWater+=rMax-height[j];
                j--;
            }
        }
        return trappedWater;
    }
}