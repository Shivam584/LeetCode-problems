class DoubleLinkedList
{
    Node head,tail;
     public DoubleLinkedList(Node h)
    {
       head=tail=h;
    }
}

class Node
{
    int key,value,freq;
    Node prv,nxt;
    public Node(int key,int val)
    {
        this.key=key;
        this.freq=1;
        this.value=val;
        prv=nxt=null;
    }
    @Override 
    public boolean equals(Object Obj)
    {
        if(Obj==null || Obj.getClass()!=getClass())
            return false;
        Node obj = (Node)Obj;
        return (obj==this || (this.freq == obj.freq && obj.key==this.key && obj.value==this.value));
    }   
    @Override
    public int hashCode()
    {
        return Objects.hash(key,value,freq,prv,nxt);
    }
}

class LFUCache {
    Map<Integer,Node> mp;
    Map<Integer,DoubleLinkedList> mf;
    int minFreq;
    int c;
    public LFUCache(int capacity) {
        this.c=capacity;
        this.mp = new HashMap<Integer,Node>();
        this.mf = new HashMap<Integer,DoubleLinkedList>();
        minFreq=1;
    }
    public void remove(Node n)
    {
        mp.remove(n.key);
        DoubleLinkedList currentNode= mf.get(n.freq);
        Node left=n.prv;
        Node right=n.nxt;

        n.prv=n.nxt=null;
        if(left!=null)
            left.nxt=right;
        if(right!=null)
            right.prv=left;

        if(currentNode.head==currentNode.tail)
            {
                if(minFreq==n.freq)
                    minFreq++;
                currentNode.head=currentNode.tail=null;
                mf.remove(n.freq);
            }
        else if(currentNode.head==n)
            currentNode.head=right;
        else if(currentNode.tail==n)
            currentNode.tail=left;
    }

    public void add(Node n)
    {
        if(n.freq<minFreq)
            minFreq=n.freq;
        
        mp.put(n.key,n);
        DoubleLinkedList currentNode=mf.get(n.freq);

        if(currentNode!=null)
            {
                currentNode.tail.nxt=n;
                n.prv=currentNode.tail;
                currentNode.tail=n;
            }
        else
        {
            currentNode = new DoubleLinkedList(n);
            mf.put(n.freq,currentNode);
        }
    }
    public int get(int key) {
        Node n=mp.get(key);
        if(n==null)
            return -1;
        remove(n);
        n.freq++;
        add(n);
      return n.value;
    }
    
    public void put(int key, int value) {
        Node n=mp.get(key);
        if(n==null)
            {
                n= new Node(key,value);
                if(c==0)
                    remove(mf.get(minFreq).head);
                else
                    c--;
            }
        else
            {
                remove(n);
                n.value=value;
                n.freq++;
            }
        add(n);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



