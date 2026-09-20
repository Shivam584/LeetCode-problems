class Solution {
    int dp(int n, int [][]st,int target,int startFuel)
    {
        int farthest=startFuel;
        int maxfuel=0;
        int k=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {return Integer.compare(b,a);});
       for(int i=0;i<n;i++)
       {
            while(!pq.isEmpty() && farthest<st[i][0])
            {
                k++;
                farthest+=pq.poll();
            }
             if(st[i][0]>farthest)
                    return -1;
                pq.offer(st[i][1]);
            if(farthest>=target)
                break;
       }
         while(!pq.isEmpty() && farthest<target)
            {
                k++;
                farthest+=pq.poll();
            }
        if(target>farthest)
            return -1;
        return k;
    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n=stations.length;
        int f=startFuel;
        if(startFuel >=target)
            return 0;

        return dp(n,stations, target, startFuel);

    }
}