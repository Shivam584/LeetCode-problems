class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,area=0;
      while(i<j)
      {
        area=Math.max(area,(j-i)*Math.min(height[j],height[i]));
        if(height[i]<height[j])
        i++;
        else
        j--;
      }  
      return area;
    }
}