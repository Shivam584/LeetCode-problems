class Node
{
    int ch[];
    public Node(String s)
    {
        ch= new int[26];
        for(char c : s.toCharArray())
            ch[c-'a']++;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if(obj==null || obj.getClass()!=getClass())
            return false;
        Node n=(Node) obj;
        for(int i=0;i<26;i++)
            if(this.ch[i]!=n.ch[i])
                return false;
        return true;
    }

     @Override
    public int hashCode()
    {
        return Arrays.hashCode(ch);
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Node,List<String>> mp =new HashMap<>();
        List<String> sl;
        List<List<String>> sll =new ArrayList<List<String>>();
        for(String s : strs)
        {
            Node n= new Node(s);
            sl=mp.get(n);
            if(sl==null)
            mp.put(n,new ArrayList<String>());
            mp.get(n).add(s);
        } 
        for(Map.Entry<Node,List<String>> entry : mp.entrySet())
        {
            sll.add(entry.getValue());
        }
        return sll;
    }
}