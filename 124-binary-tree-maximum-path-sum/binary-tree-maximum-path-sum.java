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
    int maxSum;
    int sumCal(TreeNode root)
    {
        if(root==null)
            return Integer.MIN_VALUE+1000;
        if(root.left==root.right)
        {
            maxSum=Math.max(maxSum,root.val);
            return root.val;
        }
        int l=sumCal(root.left);
        int r=sumCal(root.right);
        int maxEdge=Math.max(l,r);
        maxSum=Math.max(maxSum,root.val+Math.max(0,Math.max(l+r, maxEdge)));
        return Math.max(maxEdge,0)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE+1000;
        sumCal(root);
        return maxSum;
    }
}