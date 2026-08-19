class Solution {
    public int longestValidParentheses(String s) {
        int l=0,n=s.length(),c=0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        for(int i=0;i<n;i++)
        {
            st.push(i);
            if(s.charAt(i)=='(')
                c++;
            else if(c>0)
                {
                    st.pop();
                    st.pop();
                    c--;
                }
            l=Math.max(l,i-st.peek());
        }
        return l;
    }
}