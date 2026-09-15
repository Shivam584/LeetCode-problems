class Solution {
    int t[][];
    int dp( List<List<Integer>> ls,int []coins, int i,int n,int k, int p)
    {
        if(t[i][p]!=-1)
            return t[i][p];
        int a= coins[i]>>(p+1),b=(coins[i]>>p)-k;

        for(int l : ls.get(i))
     {
            b+=dp(ls,coins,l,n,k,p);
           a+=dp(ls,coins,l,n,k,Math.min(p+1,15));
    }
        return t[i][p]=Math.max(a,b);
    }
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n=coins.length;
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++)
            ls.add(new ArrayList<Integer>());

        for(int ed[] : edges)
        {
            if(ed[0]<ed[1])
                ls.get(ed[0]).add(ed[1]);
            else 
               ls.get(ed[1]).add(ed[0]);
        }      
        t= new int[n][16];
        for(int i=0;i<n;i++)
            for(int j=0;j<16;j++)
            t[i][j]=-1;
        return dp(ls,coins,0,n,k,0);    
    }
}
// case 1 not taken return 0;
// case 2 taken with coins[i]-k option 
// case 3 taken with coins/2 option