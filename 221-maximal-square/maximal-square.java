class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int ans[][]= new int[m+1][n+1];
       for(int i=1;i<=m;i++)
       {
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1]=='1')
                    ans[i][j]=1+Math.min(Math.min(ans[i-1][j],ans[i][j-1]),ans[i-1][j-1]);
            }
       }
       int res=0;
       for(int i=0;i<=m;i++)
       for(int j=0;j<=n;j++)
        res=Math.max(res,ans[i][j]);
       return res*res;
    }
}