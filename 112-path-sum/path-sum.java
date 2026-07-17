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
    boolean val;
    boolean res(TreeNode root, int targetSum) {
        if(root==null)
            return targetSum==0;
        boolean l=res(root.left,targetSum-root.val);
        boolean r=res(root.right,targetSum-root.val);
        val = val || (l&&r);
        return  l || r ;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
         val=false;
         res(root, targetSum);
        return val;
    }
}