class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int i=0,j=0,k=0,l=0,n=nums.length;
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        while(i<n-3)
        {
            j=i+1;
            while(j<n-2)
            {
                k=j+1;
                l=n-1;
               while(k<l)
               {
                    // System.out.println(nums[i]+" "+nums[j]+" "+nums[k]+" "+nums[l]);
                    long temp = target-(1L*nums[i]+nums[j]+nums[k]+nums[l]);
                    if(temp==0)
                    {
                        ls.add(List.of(nums[i],nums[j],nums[k],nums[l]));
                        while(k<l-1 && nums[k]==nums[k+1])
                            k++;
                        while(l>k+1 && nums[l]==nums[l-1])
                            l--;
                        k++;
                        l--;
                    }
                    else if(temp<0)
                            l--;
                    else
                        k++;
               }
               while(j<n-3 && nums[j]==nums[j+1])
                        j++;
                j++;
            }
            while(i<n-4 && nums[i]==nums[i+1])
                        i++;
            i++;
        }
        return ls;
    }
}
