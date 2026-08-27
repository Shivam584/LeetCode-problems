class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
       double mn=0.0, mx=1.0;
    int ans[] = new int[2];
    ans[0]=arr[0];
    ans[1]=arr[0];
    int n=arr.length;
       while(mx - mn > 1e-12)
       {
            double mid= mn +(mx-mn)/2.0;
            int c=0;
              int v=0,g=1;
            for(int i=0;i<n-1;i++)
            {
                int j=i+1;
                while(j<n && (arr[i]*0.1) > mid*arr[j])
                    j++;
                c+=n-j;

                if(j<n && (1.0*arr[i])/arr[j] > ((1.0*v)/g))
                {
                    v=arr[i];
                    g=arr[j];
                }
            }

        if(c<k)
            mn=mid;
        else 
        {
            mx=mid;
            ans[0]=v;
            ans[1]=g;
        }

       }

        return ans;
    }
}