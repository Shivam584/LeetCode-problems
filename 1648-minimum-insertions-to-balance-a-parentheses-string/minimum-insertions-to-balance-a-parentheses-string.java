class Solution {
    public int minInsertions(String s) {
        int n=s.length();

    int c=0,l=0;
    for(int i=0;i<n;i++)
    {
        if(s.charAt(i)=='(')
            {
                if(c<0)
                    {
                        l+=(1-c)/2 +(-c)%2;
                        c=0;
                    }
                    else if(c%2==1)
                        {
                            l+=1;
                            c--;
                        }
                c+=2;
            }
        else
        {
            c--;
        }
    }
    return l+(c<0 ? (1-c)/2 +(-c)%2 : c);
    }
}
