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
    int result( TreeNode root, TreeNode pr)
    {
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return ((pr!=null && pr.left==root) ? root.val : 0);
        
        return result(root.left,root) + result(root.right,root);
    }
    public int sumOfLeftLeaves(TreeNode root) {
       
       return result(root,null);
    }
}