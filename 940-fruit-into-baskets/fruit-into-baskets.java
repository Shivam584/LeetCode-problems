class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp = new HashMap<>();
        int i=0,j=0,l=0,n=fruits.length,ans=0,f=0;
        while(j<n)
        {
                f=mp.getOrDefault(fruits[j],0);
                mp.put(fruits[j],f+1);
                if(f==0)
                    l++;
         
                while(l>2 && i<j)
                {
                    f=mp.get(fruits[i]);
                    if(f==1)
                    {
                        mp.remove(fruits[i]);
                        l--;
                    }
                    else
                        mp.put(fruits[i],f-1);
                    i++;
                }

            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}

