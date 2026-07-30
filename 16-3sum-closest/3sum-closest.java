class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int i=0,j=0,k=0,n=nums.length;
        int l=Integer.MAX_VALUE,temp,ans=0;
        Arrays.sort(nums);
        while(i<n-2)
        {
            j=i+1;
            k=n-1;
            while(j<k)
            {
                temp=nums[i]+nums[j]+nums[k];
                if(Math.abs(temp-target)<l)
                    {
                        l=Math.abs(temp-target);
                        ans=temp;
                    }
                if(target>temp)
                j++;
                else
                k--;
            }
            i++;
        }
        return ans;
    }
}