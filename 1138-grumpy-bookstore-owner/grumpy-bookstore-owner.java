class Solution {
    public int maxSatisfied(int[] c, int[] g, int m) {
        int n=c.length;
        for(int i=0;i<n;i++)
        {
            g[i]=g[i]*c[i];
        }
        int ans=0;
        int i=0,j=0;
        int mi=0,mj=0;
        int sum=0;
        while(j<n)
        {
            sum+=g[j];
            if(j-i+1==m)
            {
                if(sum>ans)
                {
                    mj=j;
                    mi=i;
                    ans=sum;
                }
                sum-=g[i];
                i++;
            }
            j++;
        }
        ans=0;
        for(i=0;i<n;i++)
        {
            if(i>=mi && i<=mj)
            ans+=c[i];
            else
            ans+=(g[i]!=0?0:c[i]);
        }

        return ans;
    }
}