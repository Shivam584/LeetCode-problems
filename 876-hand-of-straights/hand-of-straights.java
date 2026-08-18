class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)
            return false;
        Arrays.sort(hand);
        List<List<Integer>> ls =new ArrayList<List<Integer>>();
    
        int sz=n/groupSize;
        for(int i=0;i<sz;i++)
        ls.add(new ArrayList<Integer>());
        int k=0;
        for(int num : hand)
        {     
            int fg=0;
              for(int i=0;i<sz;i++)
              {
                    if(ls.get(i).size()==0 ||( ls.get(i).size() <groupSize && ls.get(i).get(ls.get(i).size()-1)+1==num))
                        {
                            ls.get(i).add(num);
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
