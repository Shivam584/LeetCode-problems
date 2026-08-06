class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxStartPoint=0;
        for(int[] trip : trips)
            maxStartPoint =Math.max(maxStartPoint,trip[2]);
        int[] range= new int[maxStartPoint+2];

        for(int[] trip : trips)
        {
            int s=trip[1];
            int e=trip[2];
            int c=trip[0];

            range[s]+=c;
            range[e]-=c;
        }
        if(range[0]>capacity)
        return false;
        for(int i=1;i<=maxStartPoint;i++)
        {
            range[i]+=range[i-1];
            if(range[i]>capacity)
                return false;
        }
        return true;
    }
}