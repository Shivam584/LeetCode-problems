class Solution {
    int t[][];
    int mod=1000_000_007;
    int dp(int arr[][], int n,int i)
    {
        if(n==0)
            return 1;
        if(t[n][i]!=-1)
            return t[n][i];
        int temp=0;
        for(int k=0;k<arr[i].length;k++)
            temp=(int)((temp+(long)dp(arr,n-1,arr[i][k])%mod)%mod);
        t[n][i]=temp;
        return temp;
    }
    public int knightDialer(int n) {
        int arr [][]= {
            {4,6},
            {6,8},
            {7,9},
            {4,8},
            {3,9,0},
            {},
            {1,7,0},
            {2,6},
            {1,3},
            {2,4}
        };
        t= new int[n+1][10];
        int ans=0;
        for(int i=0;i<=n;i++)
        for(int j=0;j<10;j++)
                t[i][j]=-1;
        for(int i=0;i<10;i++)
            ans=(int)((ans+(long)dp(arr,n-1,i))%mod);
           return ans;
    }
}