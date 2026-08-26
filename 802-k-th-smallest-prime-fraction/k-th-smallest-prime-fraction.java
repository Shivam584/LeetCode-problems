class Pair
{
    int a,b;
    double c;
    public Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
        this.c= (double)a/b;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null || obj.getClass()!=getClass())
            return false;
        Pair p= (Pair)obj;
        return p==this || (p.a==this.a && p.b==this.b);
    } 

    @Override
    public int hashCode()
    {
        return Objects .hash(a,b);
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((A,B)->{
            return Double.compare(B.c,A.c);
        });


        for(int i=0;i<arr.length-1;i++)
        for(int j=i+1;j<arr.length;j++)
        {
            pq.offer(new Pair(arr[i],arr[j]));
            if(pq.size()>k)
                pq.poll();
        }
        return new int[]{pq.peek().a, pq.peek().b};
    }
}