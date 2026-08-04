class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s =new HashSet<>();
        for(int num : nums)
            s.add(num);
        int fg,mx=0,val=0;
        for(int num : nums)
        {
            if(!s.contains(num-1))   
            {
                fg=num;
                val=1;
                while(s.contains(fg+1))
                {
                    fg++;
                    val++;
                    s.remove(fg);
                }
            }
            mx=Math.max(mx,val);
            val=1;
        }
        return mx;
    }
}