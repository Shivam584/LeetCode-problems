class Pair
{
    int v,b;
    public Pair(int v,int b)
    {
        this.v=v;
        this.b=b;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null || obj.getClass()!=getClass())
            return false;
        Pair p=(Pair)obj;
        return p.v==this.v & p.b==this.b;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(v,b);
    }
}
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
    Set<Integer> s= new HashSet<>();
        for(int f : forbidden)
            s.add(f);
        int range=6000;
        Set<Pair> v= new HashSet<>();
        Deque<Pair> dq = new ArrayDeque<>();
        dq.addLast(new Pair(0,1));
        v.add(new Pair(0,1));
        int c=0;
        while(!dq.isEmpty())
        {
            int n=dq.size();
            for(int k=0;k<n;k++)
            {
                Pair p=dq.pollFirst();
                int curr=p.v;
                int c1=curr+a;
                Pair p1= new Pair(c1,1);
                int c2=curr-b;
                Pair p2 = new Pair(c2,-1);
                if(curr==x)
                    return c;

                if(c1<=range && (!s.contains(c1)) &&  !v.contains(p1))
                {

                    v.add(p1);
                    dq.addLast(p1);
                }
                if(c2>=0 && (!s.contains(c2)) &&  !v.contains(p2) && p.b!=-1)
                {
                   v.add(p2);
                    dq.addLast(p2);  
                }
            }
            c++;
        }
        return -1;
    }
}


