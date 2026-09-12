class Solution {

    public int superEggDrop(int k, int n) {
        int t[][]= new int[k+1][n+1];
            for(int i=1;i<=k;i++)
                t[i][1]=1;
                t[0][1]=0;
            for(int j=0;j<=n;j++)
                t[1][j]=j;
            
        for(int i=2;i<=k;i++)
        {
            for(int j=2;j<=n;j++)
            {
                t[i][j]=Integer.MAX_VALUE;
                int a=1,b=j,l;
                while(a<=b)
                {
                    l=a+(b-a)/2;
                    t[i][j]=Math.min(t[i][j], 1 + Math.max(t[i-1][j-l],t[i][l-1]));

                    if(t[i-1][j-l]>t[i][l-1])
                    a=l+1;
                    else
                    b=l-1;
                }
               
            }
        }
       return t[k][n]; 
    }
}