class Solution {
    public int maxSatisfied(int[] c, int[] gk, int m) {
        int n=c.length;
        int g[]=new int[n];
        for(int i=0;i<n;i++)
        {
            g[i]=gk[i]*c[i];
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
            ans+=(gk[i]==0?c[i]:0);
        }

        return ans;
    }
}