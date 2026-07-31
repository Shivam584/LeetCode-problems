class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int minDay=1,maxDay=0;
        for(int bloom :bloomDay)
            maxDay=Math.max(maxDay,bloom);
        int ans=Integer.MAX_VALUE,c,cm;

        while(minDay<=maxDay)
        {
            int midDay=minDay+(maxDay-minDay)/2;
            c=k;
            cm=0;
            for(int b : bloomDay)
            {
                c=(b<=midDay) ? c-1 : k;

                if(c==0)
                {   
                    cm++;
                    c=k;
                }
            }
            if(cm>=m)
            {
                ans=Math.min(ans,midDay);
                maxDay=midDay-1;
            }
            else
                minDay=midDay+1;
        }
        return (ans==Integer.MAX_VALUE) ? -1 :ans;
    }
}