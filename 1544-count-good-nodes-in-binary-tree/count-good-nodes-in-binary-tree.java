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
    int count(TreeNode root, int val)
    {
        if(root==null)
            return 0;
        
        val=Math.max(val,root.val);

    return ((val<=root.val) ? 1 : 0) + count(root.left,val)+count(root.right,val);
       
    }
    public int goodNodes(TreeNode root) {
        return count(root,root.val);
    }
}