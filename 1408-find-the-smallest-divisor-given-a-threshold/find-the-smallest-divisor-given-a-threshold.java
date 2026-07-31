class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int minDivisior =1,maxDivisior=0;
        for(int num : nums)
            maxDivisior=Math.max(maxDivisior, num);

        int ans=maxDivisior;
        while(minDivisior<=maxDivisior)
        {
            int midDivisior= minDivisior +(maxDivisior-minDivisior)/2;
            int kc=0;
            for(int num : nums)
            {
                kc+=num/midDivisior + ((num % midDivisior!=0) ? 1:0);
            }
            if(kc<=threshold)
            {
                ans=Math.min(midDivisior,ans);
                maxDivisior=midDivisior-1;
            }
            else
            minDivisior=midDivisior+1;
        }
        return ans;
    }
}