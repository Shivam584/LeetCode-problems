class Solution {
 
    public boolean canCross(int[] s) {
        int n=s.length;
        if((s[n-1]>s[0] + (((n-1)*n)/2)) || (s[1]-s[0]!=1))
            return false;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++)
            mp.put(s[i],i);

        boolean t[][]= new boolean [n][n];
        for(int j=0;j<n;j++)
            t[n-1][j]=true;
        for(int i=n-1;i>-1;i--)
            for(int p=i-1;p>=0;p--)
               {
                    int diff=s[i]-s[p]-1;
                    for(int l=0;l<3;l++)
                    {
                        Integer x= mp.get(s[i]+diff+l);
                        if(x!=null && x!=i)
                            t[i][p]=t[i][p] || t[x][i];
                    }
                    if(t[0][1])
                        return true;
               }
        return t[1][0];
    }
}