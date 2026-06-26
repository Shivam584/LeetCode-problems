class Solution {
    List<String> ls;
    void dp(int n,int o,StringBuilder s)
    {
        if(n==0 && o==0)
        {
            ls.add(s.toString());
            return;
        }
        if(o>0)
        {
            s.append(')');
            dp(n,o-1,s);
            s.deleteCharAt(s.length() - 1);
        }
        if(n>0)
        {
            s.append('(');
            dp(n-1,o+1,s);
            s.deleteCharAt(s.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ls = new ArrayList<>();
        dp(n,0, new StringBuilder(""));
        return ls;
    }
}