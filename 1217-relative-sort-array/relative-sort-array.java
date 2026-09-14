class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int n=arr2.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int x: arr2)
            mp.put(x,0);
        int c=0;
        int l=arr1.length-1;
        for(int i=arr1.length-1;i>-1;i--)
        {
            if(!mp.containsKey(arr1[i]))
            {
                arr1[l]=arr1[i];
                l--;
            }
            else
                mp.put(arr1[i],mp.get(arr1[i])+1); 
        }
        l=0;
        for(int i=0;i<n;i++)
        {
            int c1=mp.get(arr2[i]);
            for(int j=0;j<c1;j++)
                arr1[l++]=arr2[i];
        }
        return arr1;
    }
}