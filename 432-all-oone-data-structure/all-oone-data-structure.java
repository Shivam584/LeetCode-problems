class Node
{
    int c;
    String s;
    Node tail;
    Node head;
    public Node (String s, int c)
    {
        this.s=s;
        this.c=c;
        head=tail=null;
    }
}

class AllOne {
    Map<String,Node> mp;
    TreeMap<Integer,Node> mf;
    public AllOne() {
        mp= new  HashMap<String,Node>();
        mf= new TreeMap<Integer,Node>();
    }
    void add(Node node)
    {
        mp.put(node.s,node);
        Node Tail= mf.get(node.c);
        if(Tail!=null)
        {
            node.head=Tail;
            Tail.tail=node;
            Tail=node;
        }
        else
            Tail=node;
        mf.put(node.c,Tail);
    }

    void remove(Node node)
    {
        mp.remove(node.s);
        Node prv=node.head;
        Node nxt=node.tail;
        node.head=node.tail=null;
        if(prv==null && nxt==null)
            mf.remove(node.c);
        else if(nxt==null)
            mf.put(node.c,prv);
        if(prv!=null)
            prv.tail=nxt;
        if(nxt!=null)
            nxt.head=prv;
    }
    public void inc(String key) { 
       Node node=mp.get(key);
       if(node!=null)
        {
            remove(node);
            node.c++;
        }
        else
            node=new Node(key,1);
        add(node);
    }
    
    public void dec(String key) {
        Node node=mp.get(key);
        remove(node);
        node.c--;
        
        if(node.c>0)
            add(node);
    }
    
    public String getMaxKey() {
        if(mp.size()==0)
        return "";
        return mf.lastEntry().getValue().s;
    }
    
    public String getMinKey() {
        if(mp.size()==0)
        return "";
          return mf.firstEntry().getValue().s;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
