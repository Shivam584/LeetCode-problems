class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count=0,i=0,j=0,n=nums.length;
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
        int l=0,ans=0,r=0;
        while(j<n)
        {
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            if(mp.get(nums[j])==1)
                l++;
            while(l>k && i<j)
            {
                int c=mp.get(nums[i]);
                if(c==1)
                    {
                        mp.remove(nums[i]);
                        l--;
                    }
                    else 
                        mp.put(nums[i],c-1);
                    i++;
                    r=0;
            }
            if(l==k)
            {
                ans++;
                ans+=r;
                while(i<j && mp.get(nums[i])>1)
                {
                    mp.put(nums[i],mp.get(nums[i])-1);
                    ans++;
                    i++;
                    r++;
                }
            }

            j++;
        }
        return ans;
    }
}

// 1 2 1 2 3
// 0 1 1+1 1+1+1 1 
// 0 1 2 2 1
// 1 1 2 2 1

// 1 2 1 3 4 
// 0 0 0 2 1
// 0 0 0 1+1 1
// 1 1 2 1 1 

// add j in map

// if i cross k limit pop till its ==k

// once equal find all the possiblites by elminating i count 

// J++
