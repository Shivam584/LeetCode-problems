class Solution {
    int MOD=1000_000_007;
    int calcSubSeq(int nums[],int k,int n)
    {
        int t[][]= new int[n+1][k+1];
        
        t[0][0] = 1;

        for(int i=1;i<=n;i++)
            for(int j=0;j<=k;j++)
                {
                    t[i][j]=(int)(t[i-1][j]*2l)%MOD;
                    if(nums[i-1]<=j)
                        t[i][j]=(int)((long)t[i][j]+t[i-1][j-nums[i-1]])%MOD;    
                }
            
        return t[n][k];
    } 
    public int sumOfPower(int[] nums, int k) {
        int n=nums.length;
        return calcSubSeq(nums,k,n);

    }
}
