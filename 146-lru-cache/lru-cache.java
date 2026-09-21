class LRUCache {
    int c;
    Map<Integer,Integer> mp;
    public LRUCache(int capacity) {
        this.c=capacity;
        mp=new LinkedHashMap<Integer,Integer>(this.c,0.75f,true);
    }

    public int get(int key) {
        if(!mp.containsKey(key))
            return -1;
        return mp.get(key);
    }
    
    public void put(int key, int value) {
        mp.put(key,value);
        if(mp.size()>c) 
        mp.remove(mp.keySet().iterator().next());
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */