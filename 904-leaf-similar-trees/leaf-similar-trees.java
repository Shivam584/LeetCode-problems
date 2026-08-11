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
class Solution {
    void traverse(TreeNode root ,List<Integer> ls)
    {
        if(root==null)
            return;
        if(root.left==root.right)
            ls.add(root.val);
        traverse(root.left,ls);
        traverse(root.right,ls);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       List<Integer> ls1,ls2;
       ls1 = new ArrayList<>();
       ls2 = new ArrayList<>();
        traverse(root1,ls1);
        traverse(root2,ls2);

        if(ls1.size()!=ls2.size())
        return false;

        for(int i=0; i<ls2.size();i++)
        {
            if(!ls1.get(i).equals(ls2.get(i)))
                return false;
        }
        return true;
    }
}