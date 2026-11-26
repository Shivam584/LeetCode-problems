class Solution {
    public boolean canAliceWin(int n) {
        int j=10;
        int p=1;
        while(n>0)
        {
            n=n-j;
            if(n<0)
                break;
            p=1-p;
            j--;
        }        
        return p==0;
    }
}
