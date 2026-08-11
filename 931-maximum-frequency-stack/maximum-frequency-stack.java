class FreqStack {

    Map<Integer,Integer> mp;
    TreeMap<Integer,Deque<Integer>> mf;
    public FreqStack() {
        mp= new HashMap<Integer,Integer>();
        mf= new TreeMap<Integer,Deque<Integer>>((a,b) -> {
            return Integer.compare(b,a);
        });
    }
  
    public void push(int val) {
        mp.put(val,mp.getOrDefault(val,0)+1);
        int c=mp.get(val);
        Deque<Integer> ls=mf.get(c);
        if(ls==null)
            ls=new ArrayDeque<Integer>();
        ls.addLast(val);
        mf.put(c,ls);    
    }
    
    public int pop() {
        Map.Entry<Integer,Deque<Integer>> entry= mf.firstEntry();
        int c=entry.getValue().size();
       int val= entry.getValue().peekLast();
       if(c==1)
            mf.remove(mp.get(val));
        else
            mf.get(mp.get(val)).pollLast();

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