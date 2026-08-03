class Solution {
    public int largestRectangleArea(int[] heights) {
            Deque<Integer> dq =new ArrayDeque<>();
            int n=heights.length;
            int ans=0,j=0,k=0;
            for(int i=0;i<heights.length;i++)
            {
                    while(!dq.isEmpty() && heights[dq.getLast()]>heights[i])
                    {
                        k=dq.pollLast();
                        j=dq.isEmpty() ? i : i-dq.getLast()-1;
                        ans=Math.max(ans,heights[k]*j);
                    }
                dq.addLast(i);
            }
        
        while(!dq.isEmpty())
        {
            k=dq.pollLast();
            j=(dq.isEmpty()? n: n-dq.getLast()-1 );
            ans=Math.max(ans,heights[k]*j);
        }
        return ans;
    }
}

