class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int ans[]= new int[n+1];
        int previousDiagonal=0;
        int res=0,temp=0;
       for(int i=1;i<=m;i++)
       {
            for(int j=1;j<=n;j++)
            {
                temp=ans[j];
                if(matrix[i-1][j-1]=='1')
                {
                    ans[j]=1+Math.min(Math.min(ans[j],ans[j-1]),previousDiagonal);
                    res=Math.max(res,ans[j]);
                }
                else
                    ans[j]=0;
                previousDiagonal=temp;
            }
       }
    
       return res*res;
    }
}