class Solution {
    int cal(int h[], int n)
    {
        Stack<Integer> s= new Stack<>();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty() && h[s.peek()]>h[i])
            {
                int k=s.pop();
                int len = s.isEmpty() ? i : i-s.peek()-1;
                ans=Math.max(ans,len*h[k]);
            }
            s.push(i);
        }

            while(!s.isEmpty())
            {
                int k=s.pop();
                int len = s.isEmpty() ? n : n-s.peek()-1;
                ans=Math.max(ans,len*h[k]);
            }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int t[][]= new int[m][n];

        for(int j=0;j<n;j++)
            t[0][j]=matrix[0][j]-'0';
        
        for(int i=1;i<m;i++)
        for(int j=0;j<n;j++)
            if(matrix[i][j]=='1')
                t[i][j]=1+t[i-1][j];
        int ans=0;

        for(int i=0;i<m;i++)
            ans=Math.max(ans,cal(t[i],n));
        return ans;
    }
}