class Solution {
 
    public int findLength(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length,ans=0,temp1=0,temp2=0;
        int dp[]= new int[n2+1];
        for(int i=0;i<=n1;i++)
        for(int j=0;j<=n2;j++)
        { 
            temp1=dp[j];
            if(i==0 || j==0)
                dp[j]=0;
            else
            {
                if(nums1[i-1]==nums2[j-1])
                    {
                       
                        dp[j]=1+temp2;
                    }
                else
                    dp[j]=0;
                ans=Math.max(ans,dp[j]);
            }
            temp2=temp1;
        }
      
        return ans;
    }
}