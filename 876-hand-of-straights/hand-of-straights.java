class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)
            return false;
        int sz=n/groupSize;
        int l[]= new int[sz];
        int v[]= new int[sz];
        for(int i=0;i<sz;i++)
            v[i]=-1;
        int k=0;

        Arrays.sort(hand);
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

        return true;
    }
}
