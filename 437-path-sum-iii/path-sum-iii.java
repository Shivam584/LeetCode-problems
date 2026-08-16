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
     public int count(TreeNode root, long targetSum)
     {
         if(root==null)
            return 0;
        
        int res= (root.val==targetSum) ? 1 : 0;

        return res+count(root.left,targetSum-root.val) + count(root.right,targetSum-root.val);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        return count(root,(long)targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum)  ;
    }
}