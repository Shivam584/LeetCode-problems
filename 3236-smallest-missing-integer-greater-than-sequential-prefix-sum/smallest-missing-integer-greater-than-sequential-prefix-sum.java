class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> ms=new HashSet<>();
        for(int num: nums)
            ms.add(num);
        int val=nums[0];
        int c=1;
        for(int i=1;i<nums.length;i++)
        {
            if(val+c==nums[i])
                    c++;
            else
               break;
        }
        val--;
        int sum= val*c + (c*(c+1))/2;
        while(ms.contains(sum))
            sum++;
        return sum;
    }
}