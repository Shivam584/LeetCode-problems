
class Solution {
    
    // int dp(int i,int n,int nums[],int diff)
    // {
    //     if(i>=n)
    //         return 0;
    //     Pair p = new Pair(i,diff);
    //     if(t.containsKey(p))
    //         return t.get(p);

    //     int temp=0;
    //         if(diff==1000)
    //             temp=dp(i+1,n,nums,diff);
    //         for(int j=i+1;j<n;j++)
    //         {
    //             if(diff==1000)
    //                 temp=Math.max(temp,2+dp(j,n,nums,nums[j]-nums[i]));    
    //             else if((nums[j]-nums[i])==diff)
    //                 temp=Math.max(temp,1+dp(j,n,nums,diff));
    //         }
    //     t.put(p,temp);
    //     return temp;
    // }
    public int longestArithSeqLength(int[] nums) {
        
       int n=nums.length;
       int dp[][]= new int[n+1][1001];
       int ans=0;
       for(int i=0;i<n;i++)
       {
            for(int j=0;j<i;j++)
            {
               int diff=nums[j]-nums[i]+500;
               dp[i][diff]=Math.max(dp[i][diff],Math.max(2,1+dp[j][diff]));
               ans=Math.max(ans,dp[i][diff]);
            }
       }
       return ans;
    }
}