class FreqStack {

    Map<Integer,Integer> mp;
    TreeMap<Integer,List<Integer>> mf;
    public FreqStack() {
        mp= new HashMap<Integer,Integer>();
        mf= new TreeMap<Integer,List<Integer>>((a,b) -> {
            return Integer.compare(b,a);
        });
    }
  
    public void push(int val) {
        mp.put(val,mp.getOrDefault(val,0)+1);
        int c=mp.get(val);
        List<Integer> ls=mf.get(c);
        if(ls==null)
            ls=new ArrayList<Integer>();
        ls.add(val);
        mf.put(c,ls);    
    }
    
    public int pop() {
        Map.Entry<Integer,List<Integer>> entry= mf.firstEntry();
        int c=entry.getValue().size();
       int val= entry.getValue().get(c-1);
       if(c==1)
            mf.remove(mp.get(val));
        else
            mf.get(mp.get(val)).remove(c-1);

        if(mp.get(val)>1)
            mp.put(val,mp.get(val)-1);
        else
            mp.remove(val);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */