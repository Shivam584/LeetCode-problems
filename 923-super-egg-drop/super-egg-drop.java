class Solution {

    public int superEggDrop(int k, int n) {
        int t[]= new int[k+1];
        int m=0;
        while(t[k]<n)
        {
            m++;
            for(int i=k;i>=1;i--)
            t[i]=t[i]+t[i-1]+1;
        }
       return m; 
    }
}