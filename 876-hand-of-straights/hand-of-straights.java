class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)
            return false;
        Arrays.sort(hand);
        List<List<Integer>> ls =new ArrayList<List<Integer>>();
    
        int sz=n/groupSize;
        int l[]= new int[sz];
        int v[]= new int[sz];
        for(int i=0;i<sz;i++)
            v[i]=-1;
        for(int i=0;i<sz;i++)
        ls.add(new ArrayList<Integer>());
        int k=0;
        for(int num : hand)
        {     
            int fg=0;
              for(int i=0;i<sz;i++)
              {
                    if(v[i]==-1 || (l[i]<groupSize && v[i]+1==num))
                        {
                           v[i]=num;
                            l[i]++;
                            fg=1;
                            break;

                        }
              }
              if(fg==0)
                    return false;
        }
        // for( int i=0;i<sz;i++)
        // {
        //     for(int j=0 ;j<ls.get(i).size();j++)
        //         System.out.print(ls.get(i).get(j));
        //     System.out.print("\n");
        // }
        return true;
    }
}
