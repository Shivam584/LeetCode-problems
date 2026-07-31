class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxW=0;
         int minW=1;
        for(int weight : weights)
            {
                minW=Math.max(minW,weight);
                maxW+=weight;
            }
       
        int ans=maxW;
       
        while(minW<=maxW)
        {
            int midW=minW+(maxW-minW)/2;
            long calD=1,temp=0;
            for(int weight : weights)
            {
                if(temp+weight<=midW)
                    temp+=weight;
                else
                {
                    calD++;
                    temp=weight;
                }
            }
                
            if(calD<=days)
            {
                ans=Math.min(ans,midW);
                maxW=midW-1;
            }
            else
                minW=midW+1;
        }
        return ans;
    }
}