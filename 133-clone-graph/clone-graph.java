/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node clone(Node node,Map<Integer,Node> mp)
    {
        Node newNode=mp.get(node.val);
        if(newNode!=null)
            return newNode;
        newNode= new Node(node.val);
        mp.put(node.val,newNode);
        for(Node nextNode : node.neighbors)
        {
            newNode.neighbors.add(clone(nextNode,mp));
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        Map<Integer,Node> mp = new HashMap<>();
        return clone(node,mp);
    }
}