class Node
{
    int key,value;
    Node left,right;
    public Node(int key, int val)
    {
        this.key=key;
        this.value=val;
        left=right=null;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj==this)
        return true;
        if(obj==null || obj.getClass()!=getClass())
            return false;
        Node n=(Node)obj;
        return n.key==this.key && this.value==this.value && this.left==n.left && this.right==n.right; 
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(key,value);
    }
}
class LRUCache {
    Map<Integer,Node> mp;
    Node head,tail; 
    int c;
    public LRUCache(int capacity) {
        mp =new HashMap<Integer,Node>();
        head=tail=null;
        this.c=capacity;
    }
    private void setNodeAslatest(Node node)
    {
        if(tail==node)
            return;

        Node prv=node.left;
            Node nxt=node.right;
            node.left=node.right=null;

            if(head==node)
                head=nxt;
            
            if(nxt!=null)
                nxt.left=prv;
                
            if(prv!=null)
                prv.right=nxt;

            tail.right=node;
            node.left=tail;
            tail=node;
    }
    public int get(int key) {
        Node node=mp.get(key);
       if(node==null)
            return -1;
        setNodeAslatest(node);
        return tail.value;
    }
    
    public void put(int key, int value) {
        Node node=mp.get(key);
        if(node==null)
        {
            node=new Node(key,value);
            c--;
            mp.put(key,node);
        }
        if(c<0)
        {
            mp.remove(head.key);
            Node nxtHead=head.right;
            head.right=null;
            head=nxtHead;
            c++;
        }
        if(head==null)
            head=tail=node;
        node.value=value;
        setNodeAslatest(node);
    }
}
  
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */