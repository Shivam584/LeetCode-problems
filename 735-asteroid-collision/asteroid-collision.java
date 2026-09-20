class Solution {
    public int[] asteroidCollision(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<Integer>();

        for(int i=0;i<arr.length;i++)
        {
            if(dq.isEmpty() || dq.peekLast()*arr[i]>0 || dq.peekLast()<0)
                dq.addLast(arr[i]);
            else 
            {
                int b=arr[i]*-1,fg=1;
                while(!dq.isEmpty() && dq.peekLast()*arr[i]<0)
                {
                    if(Math.abs(dq.peekLast())>=b)
                        {
                            if(dq.peekLast()+arr[i]==0)
                            dq.pollLast();
                            fg=0;
                            break;
                        }
                    else 
                        dq.pollLast();
                }
                        if(fg==1)
                            dq.addLast(arr[i]);
            }
            
        }
        int ans[]= new int[dq.size()];
        int l=0;
        while(!dq.isEmpty())
            {
                ans[l++]=dq.pollFirst();
            }
        return ans;
    }
}