class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int t[][]= new int[m][n];
        for(int i=0;i<m;i++)
            t[i][0]=matrix[i][0]-'0';
        for(int i=0;i<n;i++)
            t[0][i]=matrix[0][i]-'0';

        // if(m==1 || n==1)
        // {
        //     int ans=0;
        //      for(int i=0;i<m;i++)
        //         ans=Math.max(ans,t[i][0]);
        //     for(int i=0;i<n;i++)
        //         ans=Math.max(ans,t[0][i]);
        //     return ans;
        // }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                
                if(matrix[i][j]=='1')
                {
                    t[i][j]=1+Math.min(t[i-1][j-1],Math.min(t[i][j-1],t[i-1][j]));
                }
                else
                    t[i][j]=0;
            }
        }
        int ans=0;
           for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                ans=Math.max(ans,t[i][j]);
        return ans*ans;
    }
}