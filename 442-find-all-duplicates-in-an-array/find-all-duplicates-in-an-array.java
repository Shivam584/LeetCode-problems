class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int a;
        for( int i=0;i<nums.length;i++)
        {
            a=nums[i]<0 ?-1:1;
            if(nums[a*nums[i]-1]<0)
            ls.add(a*nums[i]);
            nums[a*nums[i]-1]*=-1;
        }
        return ls;
    }
}