class Pair
{
    int a,b;
    int c;
    public Pair(int a,int b,int d)
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
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       PriorityQueue<Pair> pq = new PriorityQueue<>((A,B) -> {
        return Integer.compare(A.c,B.c);
       });

        // if(nums1[0]>nums2[0])
        // {
        //     int temp[]= nums1;
        //     nums1=nums2;
        //     nums2=temp;
        // }
        
        for(int i=0;i<nums1.length;i++)
            pq.offer(new Pair(i,0,nums1[i]+nums2[0]));
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        while(k>0)
        {
            Pair p= pq.poll();
            ans.add(List.of(nums1[p.a],nums2[p.b]));
            p.b++;
            if(p.b<nums2.length)
            {
                p.c=nums1[p.a]+nums2[p.b];
                pq.offer(p);
            }
            k--;
        }
        return ans;
    }
}