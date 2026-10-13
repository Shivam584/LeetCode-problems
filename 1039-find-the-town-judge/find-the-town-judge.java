class Solution {

    public int findJudge(int n, int[][] trust) {
        int trusted[]= new int[n];
        Set<Integer> s= new HashSet<>();
        for(int i=1;i<=n;i++)
            s.add(i);
       for(int l[] : trust)
       {
            s.remove(l[0]);
            trusted[l[1]-1]++;
       }
        for(int i=0;i<n;i++)
            if((trusted[i]==n-1) && s.contains(i+1))
                return i+1;
        return -1;
    }
}