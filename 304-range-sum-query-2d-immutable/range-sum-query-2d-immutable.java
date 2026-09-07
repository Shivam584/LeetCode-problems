class NumMatrix {
    int [][]matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        int m=matrix.length, n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                this.matrix[i][j]+=this.matrix[i][j-1];
            }
        }
         for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                this.matrix[i][j]+=this.matrix[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=matrix[row2][col2];
        if(row1>0)
            ans-=matrix[row1-1][col2];
        if(col1>0)
            ans-=matrix[row2][col1-1];
         
        if(row1>0 && col1>0)
            ans+=matrix[row1-1][col1-1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */