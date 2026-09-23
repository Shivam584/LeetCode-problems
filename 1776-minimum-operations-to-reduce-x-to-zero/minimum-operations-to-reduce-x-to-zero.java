class Solution {
    public int minOperations(int[] nums, int x) {
                int sum=-x;
                for(int num : nums)
                        sum+=num;

                int i=0,j=0,n=nums.length;
                int ans=-1;
                int temp=0;
                while(j<n)
                {
                    temp+=nums[j];
                    while(i<=j && temp>sum)
                    {
                        temp-=nums[i];
                        i++;
                    }
                    if(temp==sum)
                        ans=Math.max(ans,j-i+1);
                    j++;
                }

                return ans==-1 ? -1 : n-ans;
    }
}