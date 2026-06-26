class Solution {
    public boolean dp(String s, String p,int i,int j)
    {
        if(j<0)
            return i<0;
        
        if(i>-1 &&p.charAt(j)=='.' || (i>-1 && p.charAt(j)==s.charAt(i))){
            return dp(s,p,i-1,j-1);
        }
        else if(p.charAt(j)=='*')
        {   
            if(i>-1 && (p.charAt(j-1)=='.' || (j>0 && p.charAt(j-1)==s.charAt(i))))
                return dp(s,p,i-1,j) || dp(s,p,i,j-2);
            else
                return dp(s,p,i,j-2); 
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        return dp(s,p,s.length()-1,p.length()-1);
    }
}