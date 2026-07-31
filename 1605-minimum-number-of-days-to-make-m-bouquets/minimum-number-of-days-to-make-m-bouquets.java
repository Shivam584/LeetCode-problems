class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long minDay=1L,maxDay=0;
        for(int bloom :bloomDay)
            maxDay=Math.max(maxDay,bloom);
        long ans=Long.MAX_VALUE,c,cm;

        while(minDay<=maxDay)
        {
            long midDay=minDay+(maxDay-minDay)/2;
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
        return (ans==Long.MAX_VALUE) ? -1 : (int)ans;
    }
}