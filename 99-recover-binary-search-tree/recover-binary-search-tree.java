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
        TreeNode prv,f,l;
        void doctor(TreeNode root)
        {
            if(root==null)
                return ;
            doctor(root.left);
            if(prv!=null)
            {
                if(prv.val>root.val)
                    {
                        if(f==null)
                            f=prv;
                        l=root;
                    }
            }
            prv=root;
            doctor(root.right);
        }
    public void recoverTree(TreeNode root) {
       prv=f=l=null;
       doctor(root);
       int temp=f.val;
       f.val=l.val;
       l.val=temp;
    }
}