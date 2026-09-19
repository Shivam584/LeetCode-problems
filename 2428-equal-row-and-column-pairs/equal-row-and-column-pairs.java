class Solution {
        int getKey(int arr[],int n)
        {
            long p=1l;
            long mod=1_000_000_007l;
            long k=0;
            for(int i=0;i<n;i++)
            {
                k=(p*arr[i]+k)%mod;
                p=(p*31)%mod;
            }
        return (int)k;
        }
    public int equalPairs(int[][] grid) {
        int n=grid[0].length;
        int ans=0;
        Map<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int k=getKey(grid[i],n);
             mp.put(k,mp.getOrDefault(k,0)+1);
        }
        int temp[]= new int[n];
        for(int i=0;i<n;i++)
        {
            for(int l=0;l<n;l++)
                temp[l]=grid[l][i];
            Integer val=mp.get(getKey(temp,n));
            if(val!=null)
            ans+=val;
        }

        return ans;
    }
}