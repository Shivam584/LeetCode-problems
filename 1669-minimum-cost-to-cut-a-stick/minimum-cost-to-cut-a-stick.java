
class Solution {
    int mp[][];
    int dp(int i,int j,int []cuts)
    {
        int fg=0;
        int ans= Integer.MAX_VALUE;

        if(mp[i][j]!=-1)
            return mp[i][j];
        
        for(int k=1;k<cuts.length-1;k++)
            if(i<k && k<j)
            {
                fg=1;
                ans=Math.min(ans,cuts[j]-cuts[i]+dp(i,k,cuts)+dp(k,j,cuts));
            }
        ans=fg==0 ? 0: ans;
       
        return  mp[i][j]=ans;
    }
    public int minCost(int n, int[] cuts) {

        int m=cuts.length;
        mp= new int [m+2][m+2];

        for(int i=0;i<=m+1;i++)
        for(int j=0;j<=m+1;j++) 
            mp[i][j]=-1;
        Arrays.sort(cuts);

        int nc[]= new int[m+2];
        for(int i=0;i<m;i++)
            nc[i+1]=cuts[i];
            nc[m+1]=n;

        return dp(0,m+1,nc);
    }
}
