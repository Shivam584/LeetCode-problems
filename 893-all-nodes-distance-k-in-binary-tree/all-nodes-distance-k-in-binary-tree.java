/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void getValuefromTarget(TreeNode root, int k, List<Integer> ls)
    {
        if(root==null)
            return;
        if(k==0)
            ls.add(root.val);
        getValuefromTarget(root.left,k-1,ls);
        getValuefromTarget(root.right,k-1,ls);
    }
    int checkSubTree(TreeNode root,TreeNode target, Map<TreeNode,Integer> mp)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        if(root==target)
            return 0;
       
        int l=checkSubTree(root.left,target,mp);
        int r=checkSubTree(root.right,target,mp);
        int val=1+Math.max(l,r);
        if(val>0)
            mp.put(root,val);
        
        return val;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    
        List<Integer> ls = new ArrayList<>();
        if(root==null)
            return ls;
        // getValuefromTarget(target,k,ls);
        Map<TreeNode,Integer> mp= new HashMap<>();
        int val=checkSubTree(root,target,mp);
        mp.put(target,0);
        for(Map.Entry<TreeNode,Integer> entry : mp.entrySet())
        {
            TreeNode t=entry.getKey();
            int d=entry.getValue();
            if(k>d)
            {
                if(!mp.containsKey(t.right))
                    getValuefromTarget(t.right,k-d-1,ls);
                if(!mp.containsKey(t.left))
                    getValuefromTarget(t.left,k-d-1,ls);
            }
            else if(k==d)
                ls.add(t.val);
            
        }
        return ls;
    }
}

