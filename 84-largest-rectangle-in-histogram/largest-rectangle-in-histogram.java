class Solution {
    public int largestRectangleArea(int[] heights) {
      Stack<Integer> s= new Stack<>();
      int ans=0,n=heights.length;
      for(int i=0;i<heights.length;i++)
      {
            while(!s.isEmpty() && heights[s.peek()]>heights[i])
            {
                int k=s.pop();
                int len= s.isEmpty() ? i : i-s.peek()-1;
                ans=Math.max(ans, len*heights[k]);
            }
            s.push(i);
      }  
      while(!s.isEmpty())
                {
                    int k =s.pop();
                    int len = s.isEmpty() ? n : n-s.peek()-1;
                    ans=Math.max(ans, len*heights[k]);
                }
        return ans;
    }
}