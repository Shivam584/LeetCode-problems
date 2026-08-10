class Solution {
    public List<List<Long>> splitPainting(int[][] A) {
       TreeMap<Long,Long> tmp= new TreeMap<>();
       for(int a[]: A)
       {
            tmp.put(1l*a[0],tmp.getOrDefault(a[0]*1l,0l)+a[2]*1l);
            tmp.put(1l*a[1],tmp.getOrDefault(a[1]*1l,0l)-a[2]*1l);
       }
        long sum=0;
        long i=1;
        List<List<Long>> ls = new ArrayList<List<Long>>();
       for(long k : tmp.keySet())
       {
            if(sum>0)
                ls.add(List.of(i,k,sum));
            sum+=tmp.get(k);
            i=k;
       }
       return ls;
    }
}