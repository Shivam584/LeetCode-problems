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
    int ans;
    int maxCal(TreeNode root)
    {
        if(root==null)
            return 0;
        int l=maxCal(root.left);
        int r=maxCal(root.right);
        ans=Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
       ans=0;
       maxCal(root);
       return ans-1;
    }
}