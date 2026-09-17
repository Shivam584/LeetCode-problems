class Solution {
        int mod=1_000_000_007;

       long modPow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % mod;

            a = a * a % mod;
            b >>= 1;
        }

        return res;
    }

    long comb(int n,int r)
    {
        if(n!=r)
            r=Math.min(r,n-r);

        long u=1;
        long d=1;    
        
        for(int j=1;j<=r;j++)
            {
                u=(u*n)%mod;
                d=(d*j)%mod;
                n--;
            }
        long inv_d=(modPow(d,mod-2))%mod;
        return (u*inv_d)%mod;
    }
    public int countValidSequences(int n, int k) {

        long total_seq= comb(n-1,k-1);
        long odd=0l;
    
        if(n%2==k%2)
            odd=comb((n+k)/2-1,k-1);

        return (int)(total_seq-odd+mod)%mod;
    }
}
