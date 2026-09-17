class Solution {
   
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num : nums)
            sum+=num;
       
        int rem=sum%3;
        if(rem==0)
            return sum;
        if(rem==1)
        {
             int d21=sum,d22=sum,d1=sum;
            for(int i=0;i<n;i++)
            {
                if(nums[i]%3==1)
                    d1=Math.min(d1,nums[i]);

                if(nums[i]%3==2)
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
            System.out.println(d21+" "+d22);
            return sum-Math.min(d21+d22,d1);
        }

        int d11=sum,d12=sum,d2=sum;
        for(int i=0;i<n;i++)
        {
            if(nums[i]%3==1)
            {
                if(d11>=nums[i])
                {   
                    d12=d11;
                    d11=nums[i];
                }
            }
                
           if(nums[i]%3==2)
                d2=Math.min(d2,nums[i]); 
        }

        return sum-Math.min(d11+d12,d2);
    }
}