class Solution {
   
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer,List<Integer>> mp =new HashMap<>();
        int q=queries.length;
        int n=nums.length;
        int l=nums[0].length();
        int ans[]= new int[q];
        for(int i=0;i<q;i++)
        {
            List<Integer> ls= mp.getOrDefault(queries[i][1],new ArrayList<Integer>());
            ls.add(i);
            if(ls.size()==1)
            mp.put(queries[i][1],ls);
        }
        int id[]= new int[n];
        int idx[]= new int[n];
        int temp[];
        List<Integer> ls;

        for(int i=0;i<n;i++)
            idx[i]=id[i]=i;

        for(int i=1;i<=l;i++)
        {
            int fq[]= new int[10];
            int trim[]= new int[n];

            for(int j=0;j<n;j++)
                { 
                    trim[j]=nums[id[j]].charAt(l-i)-'0';
                    fq[trim[j]]++;
                    // System.out.print(id[j]+" ");
                }
                // System.out.println();
             for(int j=1;j<10;j++)
                fq[j]+=fq[j-1];

            for(int j=n-1;j>-1;j--)
            {
                // System.out.println(fq[trim[j]]+" "+trim[j]+" "+id[j]);
                idx[fq[trim[j]]-1]=id[j];
                fq[trim[j]]--;
            }
            temp=id;
            id=idx;
            idx=temp;
            ls=mp.get(i);
            if(ls!=null)
            {
              for(int qt : ls)
                ans[qt]=id[queries[qt][0]-1];
            }
        }
        return ans;
    }
}

// 0,1,2,3  - ID
// 2,3,1,4  - trim 1

// 1,2,3,4
// 1,1,1,1

// 1,2,3,4

// -,-,-,4-> -,-,-,3
// 1,-,-,4 -> 2,-,-,3
// 1,-,3,4-> 2,-,1,3
// 1,2,3,4-> 2,0,1,3

// 2,0,1,3 -> ID 
// 5,0,7,1 -> trim 2

// 0,1,5,7
// 1,1,1,1
// 1,2,3,4

// -,3,-,-
// -,3,-,1
// 0,3,-,1
// 0,3,2,1


