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
        PriorityQueue<Pair> pq= new PriorityQueue<>((A,B)->{
            return Double.compare(A.c,B.c);
        });     
        int j=arr.length-1,n=arr.length;
        for(int i=0;i<n-1;i++){
            pq.offer(new Pair(i,j,(double)arr[i]/arr[j]));
        }

        while(k>1)
        {
            Pair p=pq.poll();
            k--;
            if(p.a<p.b)
            {
                p.b--;
                p.c=(double)arr[p.a]/arr[p.b];
                pq.offer(p);
            }
        }
        return new int[]{arr[pq.peek().a], arr[pq.peek().b]};
    }
}