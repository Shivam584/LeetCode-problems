class Solution {
    
    public boolean checkValidString(String s) {
    int n=s.length();
    char ch[]= s.toCharArray();
    int i=0,cmax=0,cmin=0;
    while(i<n)
    {
        if(ch[i]=='(')
        {
            cmax++;
            cmin++;
        }
        else if(ch[i]==')')
        {
            cmax--;
            cmin--;
        }
        else
        {
            cmax++;
            cmin--;
        }

        if(cmax<0)
            return false;
        cmin=Math.max(cmin,0);
        i++;
    }
    return cmin==0;
    }
}