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
        return Objects.hash(key,value,left,right);
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
    private void removeNode(Node node)
    {
        mp.remove(node.key);
        Node prv=node.left;
        Node nxt=node.right;
            node.left=node.right=null;
        if(prv!=null)
            prv.right=nxt;
        if(nxt!=null)
            nxt.left=prv;
        
        if(node==head)
            head=nxt;
        
        if(node==tail)     
            tail=prv;
    }
      private void addNode(Node node)
    {
        mp.put(node.key,node);

        if(head==null)
            head=node;

        node.left=tail;
        if(tail!=null)
            tail.right=node;
        tail=node;
    }
    public int get(int key) {
        Node node=mp.get(key);
       if(node==null)
            return -1;

        if(node!=tail)
        {
            removeNode(node);
            addNode(node);
        }
        return tail.value;
    }
    
    public void put(int key, int value) {
        Node node=mp.get(key);
        if(node==null)
        {
            node=new Node(key,value);
            if(c==0)
                removeNode(head);
            else
                c--;
        }
        else
            removeNode(node);
        addNode(node);    
        node.value=value;
        
    }
}
  
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */