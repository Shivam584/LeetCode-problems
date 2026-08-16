/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair
{
    TreeNode node;
    int b;
     Pair(TreeNode node,int b)
    {
        this.node=node;
        this.b=b;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null || obj.getClass()!=getClass())
            return false;
        
        Pair p = (Pair)obj;
        return p.node==this.node && this.b==p.b;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(node,b);
    }
}
class Solution {
        Map<Pair,Integer> mp;
        int dp(TreeNode root, int fg)
        {
            if(root==null)
                return 0;
            Pair p = new Pair(root,fg);
            int c=mp.getOrDefault(p,-1);
            if(c>-1)
                return c;
            int res= dp(root.left,0)+ dp(root.right,0);
            if(fg==0)
                res=Math.max(root.val +dp(root.left,1)+dp(root.right,1),res);
            mp.put(p,res);
            return res;
        }
    public int rob(TreeNode root) {
        mp=new HashMap<Pair,Integer>();
        return dp(root,0);
    }
}