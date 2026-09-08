class Solution {
     int t[][];
    boolean dp(int i, int j,String s,String p)
    {
        if(i==0 && j==0)
            return true;
        if(j==0)
            return false;

        if(t[i][j]!=-1)
            return t[i][j]==1;
        
        boolean ans=false;
        if(p.charAt(j-1)=='.')
        {
            if(i==0)
                return false;
            ans=ans|| dp(i-1,j-1,s,p);
        }
        else if(p.charAt(j-1)=='*')
        {
            int k=0;
            ans= ans || dp(i,j-2,s,p);
            while(k<i && (p.charAt(j-2)=='.' || s.charAt(i-k-1)==p.charAt(j-2)))
                {ans=ans|| dp(i-k-1,j-2,s,p);k++;}
        }
        else 
        {
            if(i==0)
                return false;
            if(s.charAt(i-1)==p.charAt(j-1))
                ans = ans || dp(i-1,j-1,s,p);
        }
        

        t[i][j] = ans ? 1: 0;

        return ans;
    }
    public boolean isMatch(String s, String p) {
        int s1=s.length(), p1=p.length();
        t= new int[s1+1][p1+1];
        for(int i=0;i<=s1;i++)
        {
            for(int j=0;j<=p1;j++)
            t[i][j]=-1;
        }
        return dp(s1,p1,s,p);
    }
}

// s->i, p->j
// if(i==0 && j==0)
// return true;
// j= ch -> check case, both equal i-1,j-1
// j= . -> ignore case 
// j= * -> default : (i, j-2), while(k<=i && check case (i-k,j-1)) -> true, (i-1,j-2) 