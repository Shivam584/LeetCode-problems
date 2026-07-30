class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int reqSum=0,j=0,k=0,i=0, n=nums.length;
        List<List<Integer>> ls= new  ArrayList<List<Integer>>();
        while(i<n-2)
        {
            reqSum = -nums[i];
            j=i+1;
            k=n-1;
            while(j<k)
            {
                if(reqSum==(nums[j]+nums[k]))
                {
                ls.add(List.of(nums[i],nums[j],nums[k]));
                    while(j+1<k &&(nums[j]==nums[j+1])) 
                            j++;
                            
                    while(k-1>j &&(nums[k]==nums[k-1])) 
                            k--;
                    j++;
                    k--;
                }
                else if(reqSum<(nums[j]+nums[k]))
                    k--;
                else
                    j++;
                
            }       
            while(i<n-3 &&(nums[i]==nums[i+1])) 
                i++;  
            i++;   
        }
        return ls;
    }
}