class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minElem=nums[0],maxElem=nums[0];
        for(int i :nums)
            {minElem=Math.min(i,minElem);
            maxElem=Math.max(i,maxElem);}
        Arrays.sort(nums);

        List<Integer> ls = new ArrayList<>();
        int i=0;
        while(minElem <=maxElem)
        {
            if(nums[i]==minElem)
                i++;
            else
                ls.add(minElem);
            minElem++;
        }
    
        return ls;
    }
}