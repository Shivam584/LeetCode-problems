class Solution {
    int sum(int x)
    {
        int sum=0;
        while(x>0)
        {
            sum+=x%10;
            x/=10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(i==sum(nums[i]))
                return i;
        }
        return -1;
    }
}