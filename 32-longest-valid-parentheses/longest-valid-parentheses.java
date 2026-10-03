class Solution {
    public int longestValidParentheses(String s) {
       Deque<Integer> dq= new ArrayDeque<>();
        int c=0,ans=0;
        dq.addLast(-1);
       for(int i=0;i<s.length();i++)
        {
            dq.addLast(i);
            if(s.charAt(i)=='(')
            c++;
            else if(c>0)
            {
                dq.pollLast();
                dq.pollLast();
                c--;
            }
            ans=Math.max(ans,i-dq.peekLast());
        }        
        return ans;
    }
}
