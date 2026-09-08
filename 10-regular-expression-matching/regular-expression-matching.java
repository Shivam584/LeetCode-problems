class Solution {

    public boolean isMatch(String s, String p) {
        int s1=s.length(), p1=p.length();
        boolean t[][]= new boolean[s1+1][p1+1];

        for(int i=0;i<=s1;i++)
        {
            for(int j=0;j<=p1;j++)
            {
                if(i==0 && j==0)
                     t[i][j]= true;
                else if(j==0)
                     t[i][j]= false;
                else if(p.charAt(j-1)=='.')
                {
                    if(i==0)
                         t[i][j]= false;
                    else
                     t[i][j]= t[i][j] || t[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*')
                {
                    int k=0;
                     t[i][j] = t[i][j] || t[i][j-2];
                    while(k<i && (p.charAt(j-2)=='.' || s.charAt(i-k-1)==p.charAt(j-2)))
                        {
                            t[i][j]= t[i][j] || t[i-k-1][j-2];
                            k++;
                        }
                }
                else 
                {
                     if(i==0)
                         t[i][j]= false;
                    else if(s.charAt(i-1)==p.charAt(j-1))
                         t[i][j]= t[i][j] || t[i-1][j-1];
                }
            }
        }
        return t[s1][p1];
    }
}

// s->i, p->j
// if(i==0 && j==0)
// return true;
// j= ch -> check case, both equal i-1,j-1
// j= . -> ignore case 
// j= * -> default : (i, j-2), while(k<=i && check case (i-k,j-1)) -> true, (i-1,j-2) 