class Solution {
 
    public int minTaps(int n, int[] ranges) {
        int intervals[][]= new int [n+1][2];
        for(int i=0;i<=n;i++)
            {
                intervals[i][0]=i-ranges[i];
                intervals[i][1]=i+ranges[i];
            }
        Arrays.sort(intervals,(a,b)-> {
            if(a[0]==b[0])
                return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0],b[0]);
        });
        
        int covered=0;
        int i=0,ans=0;

        while(covered<n)
        {
            int farthest=covered;
            while(i<=n && intervals[i][0]<=covered)
                farthest=Math.max(farthest,intervals[i++][1]);

            if(farthest==covered)
                return -1;
            covered=farthest;
            ans++;
        }

        return ans;
    }
}