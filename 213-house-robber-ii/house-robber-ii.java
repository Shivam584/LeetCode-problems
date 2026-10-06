
class Solution {
    int dp(int nums[],int i,int n)
    {
        int a=0,b,c;
        b=nums[i-1];
         if(n-i+1==1)
            return b;
        c=Math.max(nums[i],nums[i-1]);
        if(n-i+1==2)
            return c;
        for(int j=i+2;j<=n;j++)
        {
            a=Math.max(b+nums[j-1],c);
            b=c;
            c=a;
        }
        return a;
    }
    public int rob(int[] nums) {

        int n=nums.length;
        if(n<2)
            return Math.max(nums[0],nums[n-1]);
        
        int c1=dp(nums,1,n-1);
        int c2=dp(nums,2,n);
        return Math.max(c1,c2);
    }
}
