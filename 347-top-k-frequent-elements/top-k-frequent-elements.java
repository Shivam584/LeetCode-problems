class Pair
{
    int a,b;
    public Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    int getValue()
    {
        return this.b;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj==this)
        return true;
        if(obj==null || obj.getClass()!=getClass())
        return false;
        Pair p = (Pair)obj;
        return p.a==this.a && this.b==p.b;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(a,b);
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp =new HashMap<>();
        for(int num : nums)
        {
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((A,B)->{
            return Integer.compare(A.a,B.a);
        });

        for(Map.Entry<Integer,Integer> entry : mp.entrySet())
        {
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
        }
        while(pq.size()>k)
            pq.poll();
        
        int ans[] = pq.stream().mapToInt(Pair::getValue).toArray();
        return ans; 
    }
}