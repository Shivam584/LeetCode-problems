class Solution {
    public int longestValidParentheses(String str) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int c=0,ans=0;
        for(int i=0;i<str.length();i++)
        {
            s.push(i);
            if(str.charAt(i)=='(')
                c++;
            else if(c>0)
            {
                c--;
                s.pop();
                s.pop();
                ans=Math.max(ans,i-s.peek());
            }
        }
        return ans;
    }
}