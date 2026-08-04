class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mp = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(mp.contains(nums[i]))
            return true;
            mp.add(nums[i]);
        }
        return false;
    }
}