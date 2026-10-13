class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
            nums[i]=Math.abs(nums[i]);
            Arrays.sort(nums);
        int i=0,j=n-1;
        long sum=0;
        while(i<j)
        {
            sum+=nums[j]*nums[j]-nums[i]*nums[i];
            i++;j--;
        }
        if(n%2==1)
            sum+=nums[i]*nums[i];
            return sum;
    }
}