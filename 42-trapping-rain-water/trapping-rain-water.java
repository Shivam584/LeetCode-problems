class Solution {
    int calcArea(int[] height, int j)
    {
        int maxLeftHeight=height[0];
        int ans=0;
        for(int i=0;i<j;i++)
        {
            if(height[i]>maxLeftHeight)
                maxLeftHeight=height[i];
            ans+=Math.min(maxLeftHeight,height[j])-height[i];
        }
        return ans;
    }
   
    public int trap(int[] height) {
        int maxHIndex=0,area=0;
        for(int i=0;i<height.length;i++)
            if(height[maxHIndex]<height[i])
                maxHIndex=i;
        area+=calcArea(height, maxHIndex);
        int i=0,j=height.length-1;
        while(i<j)
        {
            int temp=height[i];
            height[i]=height[j];
            height[j]=temp;
            i++;
            j--;
        }
        area+=calcArea(height,height.length-maxHIndex-1);
        return area;
    }
}