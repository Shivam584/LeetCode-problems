class Pair
{
    int a,b;
    double c;
    public Pair(int a,int b,double d)
    {
        this.a=a;
        this.b=b;
        this.c= d;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null || obj.getClass()!=getClass())
            return false;
        Pair p= (Pair)obj;
        return p==this || (p.a==this.a && p.b==this.b && p.c==this.c);
    } 

    @Override
    public int hashCode()
    {
        return Objects .hash(a,b,c);
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
       double mn=0.0, mx=1.0;
    int ans[] = new int[2];
    ans[0]=arr[0];
    ans[1]=arr[0];
    int n=arr.length;
       while(mx - mn > 1e-12)
       {
         double mid= mn+(mx-mn)/2;
        int c=0,p=0,q=1;
         for(int i=0;i<n-1;i++)
         {
            int j=i+1;
            while(j<n && 1.0*arr[i]>arr[j]*mid)
                j++;
            c+=(n-j);
         
                if (j < n &&
                    (double) arr[i] / arr[j] >
                    (double) p / q) {

                    p = arr[i];
                    q = arr[j];
                }
            }

            if (c < k) {
                mn = mid;
            } else {
                mx = mid;
                ans[0] = p;
                ans[1] = q;
            }
       }

        return ans;
    }
}