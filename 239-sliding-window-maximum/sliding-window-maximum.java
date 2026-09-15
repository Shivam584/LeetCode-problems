class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n=nums.length,l=0,i=0,j=0;
        int ans[]= new int [n-k+1];
        while(j<n)
        {
            while(!dq.isEmpty() && (nums[j]>nums[dq.peekFirst()] || dq.peekFirst()<i))
            {
                dq.pollFirst();
            }
             while(!dq.isEmpty() && (nums[j]>nums[dq.peekLast()] || dq.peekLast()<i))
                dq.pollLast();

            dq.addFirst(j);
            if(j-i+1==k)
                {
                    ans[l]=nums[dq.peekLast()];
                    l++;
                    i++;
                }
            j++;
        }
        return ans;
    }
}