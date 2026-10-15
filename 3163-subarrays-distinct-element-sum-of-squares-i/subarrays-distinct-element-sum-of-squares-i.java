class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        int n=nums.size();
        for(int i=0;i<n;i++)
        {
            Set<Integer> hs= new HashSet<>();
            for(int j=i;j<n;j++)
            {
               hs.add(nums.get(j));
                ans+=hs.size()*hs.size();
            }
        }
        return ans;
    }
}
