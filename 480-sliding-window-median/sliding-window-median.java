class Node
{
    long a,b;
    public Node(long a,long b)
    {
        this.a=a;
        this.b=b;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null || obj.getClass()!=getClass())
        return false;
        Node o =(Node)obj;
        return o==this || (o.a==this.a && o.b==this.b);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(a,b);
    }
}
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Node> lpq = new TreeSet<>((A,B)->{
            if(A.a!=B.a)
            return Long.compare(A.a,B.a);
            return Long.compare(A.b,B.b);
        });
        TreeSet<Node> hpq = new TreeSet<>((A,B)->{
            if(A.a!=B.a)
            return Long.compare(B.a,A.a);
            return Long.compare(A.b,B.b);
        });
        int i=0,j=0,n=nums.length;
        double ans[]= new double[n-k+1];
        int l=0; 
        while(j<n)
        {
            Node node1= new Node((long)nums[j],(long)j);
           if(hpq.isEmpty() || node1.a<=hpq.first().a)
                hpq.add(node1);
            else
                lpq.add(node1);

            while(hpq.size()-lpq.size()>1)
                    lpq.add(hpq.pollFirst());

            while(lpq.size()>hpq.size())
                    hpq.add(lpq.pollFirst());

            if(j-i+1==k)
            {

                if(k%2==1)
                    ans[l]=(double)hpq.first().a;
                else
                    ans[l]=(hpq.first().a+lpq.first().a)/2.0;
                l++;

                Node node= new Node((long)nums[i],(long)i);
                if(lpq.contains(node))
                    lpq.remove(node);
                else if(hpq.contains(node))
                    hpq.remove(node);
                
               while(hpq.size()-lpq.size()>1)
                    lpq.add(hpq.pollFirst());
                    
            while(lpq.size()>hpq.size())
                    hpq.add(lpq.pollFirst());

                i++;
            }
            j++;
        }
        return ans;
    }
}