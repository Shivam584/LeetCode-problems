class Solution {
    public int splitArray(int[] nums, int k) {
        int minSum=0,maxSum=0;
        for(int num :nums)
        {
            maxSum+=num;
            minSum=Math.max(minSum,num);
        }
        int ans=maxSum;
        while(minSum<=maxSum)
        {
            int s=minSum +(maxSum-minSum)/2;
            int kc=1;
            int temp=0;
            for(int num :nums)
            {
                if(temp+num<=s)
                    temp+=num;
                else
                {
                    kc++;
                    temp=num;
                }
            }
            
            if(kc<=k)
                {ans=Math.min(ans,s);
                maxSum=s-1;}
            else
                 minSum=s+1;
        }
        return ans;
    }
}