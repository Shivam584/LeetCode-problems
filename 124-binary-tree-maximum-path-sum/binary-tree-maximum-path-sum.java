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
    int maxresult;
    int calc(TreeNode root)
    {
        int left,right;
        left=right=-100_000_000;
        if(root.left!=null)
            left=calc(root.left);

        if(root.right!=null)
            right=calc(root.right);
        int maxvalue= Math.max(0,Math.max(left,right));
        maxresult = Math.max(maxresult,root.val+Math.max(left+right, maxvalue));
        return root.val+maxvalue;
    }
    public int maxPathSum(TreeNode root) {
        maxresult=root.val;
        calc(root);
        return maxresult;
    }
}