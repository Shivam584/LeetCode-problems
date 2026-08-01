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
        if(obj==null || getClass()!=obj.getClass())
            return false;
        Pair A=(Pair)obj;
        return (A==this) || (A.a==this.a && A.b==this.b);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(a,b);
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Pair> dq =new ArrayDeque<>();
        dq.addFirst(new Pair(0,-1));
        int ans=nums.length+1,sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            while(!dq.isEmpty() && sum-dq.getFirst().a>=k)
                {
                    ans=Math.min(ans,i-dq.getFirst().b);
                    dq.pollFirst();
                }
            while(!dq.isEmpty() && sum < dq.getLast().a)
            {
                dq.pollLast();
            }
            dq.addLast(new Pair(sum,i));
        }
        return ans==nums.length+1 ? -1 : ans; 
    }
}