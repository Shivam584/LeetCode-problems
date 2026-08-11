class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> ms=new HashSet<>();
        for(int num: nums)
            ms.add(num);
        int val=nums[0],mval=nums[0];
        int c=1,mc=1;
        for(int i=1;i<nums.length;i++)
        {
            if(val+1==nums[i])
                {c++;val++;}
            else
            {
               break;
            }
            if(mc<c)
            {
                mval=val-c;
                mc=c;
            }
        }
        System.out.println(mval +" "+mc);
        int sum= mval*mc + (mc*(mc+1))/2;
        while(ms.contains(sum))
            sum++;
        return sum;
    }
}