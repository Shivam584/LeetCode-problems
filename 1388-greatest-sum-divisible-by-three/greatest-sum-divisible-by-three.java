class Solution {
   
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num : nums)
            sum+=num;
        int rem=sum%3;
        if(rem==0)
            return sum;    
        int d11=sum,d12=sum,d21=sum,d22=sum;

        for(int i=0;i<n;i++)
        {
            if(nums[i]%3==rem)
                d11=Math.min(d11,nums[i]);
                
           if(nums[i]%3==(3-rem))
            {
                if(d21>=nums[i])
                {   
                    d22=d21;
                    d21=nums[i];
                }
                else 
                    d22=Math.min(d22,nums[i]);
            }
        }
        return sum- Math.min(d11,d21+d22);
    }
}