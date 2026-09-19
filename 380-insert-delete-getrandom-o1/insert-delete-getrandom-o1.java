class RandomizedSet {
        int n;
        List<Integer> ls;
        Map<Integer,Integer> mp;
        Random random;
    public RandomizedSet() {
        n=0;
        ls=new ArrayList<>();
        mp =new HashMap<>();
        random= new Random();
    }
    
    public boolean insert(int val) {
        Integer id=mp.get(val);
        if(id!=null)
            return false;
        ls.add(val);
        mp.put(val,n);
        n++;
        return true;
    }
    
    public boolean remove(int val) {
        Integer id=mp.get(val);
        if(id==null)
            return false;
        int temp= ls.get(n-1);
        ls.set(id,temp);
        ls.removeLast();
        mp.put(temp,id);
        mp.remove(val);
        n--;
        return true;
    }
    
    public int getRandom() {
        return ls.get(random.nextInt(n));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */