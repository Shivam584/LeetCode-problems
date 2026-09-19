class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int fg=1;
                for(int k=0;k<n;k++)
                {
                    if(grid[i][k]!=grid[k][j])
                    {fg=0;break;}
                }
                if(fg==1)
                    ans++;
            }
        }
        return ans;
    }
}