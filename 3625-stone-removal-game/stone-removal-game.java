class Solution {
    public boolean canAliceWin(int n) {
       if(n<10)
        return false;
        int j=10;
        int p=1;
        while(n>0)
        {
            n=n-j;
            if(n<0)
                return p==0;
            p=1-p;
            j--;
        }        
        return p==0;
    }
}
