class Pair
{
    int a,b;
    public Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null || obj.getClass()!=getClass())
        return false;

        Pair p = (Pair)obj;
        return (p==this) || p.a==this.a && p.b==this.b; 
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(a,b);
    }
}
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
       Deque <Pair> dq = new ArrayDeque<Pair>();
        int ans=Integer.MIN_VALUE;
       for(int i=0;i<points.length;i++)
       {
            while(!dq.isEmpty() && points[i][0]-dq.getFirst().b>k)
                dq.pollFirst();
              
            if(!dq.isEmpty())
                ans=Math.max(ans,dq.getFirst().a+points[i][0]+points[i][1]);
            
            if(dq.isEmpty()|| dq.getFirst().a<points[i][1]-points[i][0])
                dq.addFirst(new Pair(points[i][1]-points[i][0],points[i][0]));
            else
            {
                while(!dq.isEmpty() && dq.getLast().a<points[i][1]-points[i][0])
                dq.pollLast();   
                dq.addLast(new Pair(points[i][1]-points[i][0],points[i][0]));
            }
       }
       return ans;
    }
}
   