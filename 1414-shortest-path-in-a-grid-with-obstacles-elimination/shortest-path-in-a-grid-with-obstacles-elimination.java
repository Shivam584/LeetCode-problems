class Solution {
    
    public int shortestPath(int[][] grid, int k) {
       
        int m=grid.length,n=grid[0].length;
        boolean v[][][]=new boolean[m+1][n+1][k+1];
        Queue<int []> q = new ArrayDeque<>();
        q.add(new int[]{0,0,k-grid[0][0]});
        v[0][0][k-grid[0][0]]=true;
        int step=0;
        int d[][]= {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };
        while(!q.isEmpty())
        {
            int sz=q.size();
            for(int l=0;l<sz;l++)
            {
                int id[]= q.poll();
                int i=id[0];
                int j=id[1];
                int rk=id[2];

                if(i==m-1 && j==n-1)
                    return step;
                
                for(int di[] : d)
                {
                    int ni=i+di[0];
                    int nj=j+di[1];
                    if(ni<0 || nj<0 || ni>=m || nj>=n || (grid[ni][nj]==1 && rk==0) 
                    || v[ni][nj][rk-grid[ni][nj]])
                        continue;
                    q.offer(new int[]{ni,nj,rk-grid[ni][nj]});
                    // if(grid[ni][nj]==1)
                    //     q.offer(new int[]{ni,nj,rk});
                    v[ni][nj][rk-grid[ni][nj]]=true;
                }
                
            }
            step++;
        }
        return -1;
    }
}