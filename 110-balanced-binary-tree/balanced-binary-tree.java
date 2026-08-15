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
    boolean b;
    int depth(TreeNode root)
    {
        if(root==null)
        return 0;
        int l=depth(root.left);
        int r=depth(root.right);
        b=  b && (Math.abs(l-r)<2); 
        return 1+Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        b=true;
        if(root==null)
            return true;
            depth(root);
        return b;
    }
}