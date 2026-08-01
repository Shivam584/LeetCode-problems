class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n=matrix.length,m=matrix[0].length;
        int ans[][] =new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                ans[i][j]=matrix[i-1][j-1];
                ans[i][j]+=ans[i-1][j];
            }
        }
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                ans[i][j]+=ans[i][j-1];
    
         for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            System.out.print(ans[i][j]);
        System.out.println("");
        }
        int sum=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                for(int l=0;l<i;l++)
                {
                    for(int k1=0;k1<j;k1++)
                    {
                        int temp = ans[i][j]+ans[l][k1]-ans[i][k1]-ans[l][j];
                        if(temp<=k)
                            sum=Math.max(sum,temp);
                    }
                }
            }
        }
        return sum;
    }
}