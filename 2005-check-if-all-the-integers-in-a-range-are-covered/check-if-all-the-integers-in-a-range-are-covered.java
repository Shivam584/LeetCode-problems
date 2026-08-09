class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        try
        {
            int range[]= new int[51];
        for(int r[] : ranges)
        {
            range[r[0]]+=1;
            if(r[1]<50)
            range[r[1]+1]-=1;
        }
        for(int i=1;i<51;i++)
            range[i]+=range[i-1];
        
        while(left<=right)
            if(range[left++]==0)
                return false;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    return true;
    }
}