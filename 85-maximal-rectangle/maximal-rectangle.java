class Solution {
    int t[][];
    int resolve(int[][] mat, int m,int n)
    {
        if(m==0 || n==0)
        return 0;
        if(m*n==mat[m][n])
        return mat[m][n];
        if(t[m][n]!=-1)
        return t[m][n];
        int temp=0;
        for(int i=m;i<mat.length;i++)
        {
            for(int j=n;j<mat[0].length;j++)
            {
                temp=mat[i][j]-mat[i-m][j]-mat[i][j-n]+mat[i-m][j-n];
                if(temp==m*n)
                    break;
            }
            if(m*n==temp)
            break;
        }   
        if(m*n!=temp)
            temp=Math.max(resolve(mat,m-1,n-1),Math.max(resolve(mat,m,n-1),resolve(mat,m-1,n)));
        t[m][n]=temp;
        return temp;
    }
    public int maximalRectangle(char[][] matrix) {
        int a,b;
        int m=matrix.length, n=matrix[0].length;
        int dp[][]= new int[m+1][n+1];
        t= new int[m+1][n+1];
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
               {dp[i][j]=(j>1?dp[i][j-1]:0)+matrix[i-1][j-1]-'0';t[i][j]=-1;}
        for(int i=1;i<=n;i++)
            for(int j=2;j<=m;j++)
               dp[j][i]+=dp[j-1][i];
        return resolve(dp,m,n);
    }
}