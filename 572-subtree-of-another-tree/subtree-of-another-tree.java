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
        
    public boolean isSubtree(TreeNode root, TreeNode subRoot, int fg) {
        if(root==null && subRoot==null)
            return true;

        if(root==null || subRoot==null)
            return false;
        boolean R1=false,R2=false; 
        if(root.val==subRoot.val)
            R2=(isSubtree(root.left,subRoot.left,1) && isSubtree(root.right,subRoot.right,1));  
        
        if(fg==0)
           R1=isSubtree(root.left,subRoot,fg) || isSubtree(root.right,subRoot,fg);
        return (fg==1) ? R2 : R1 || R2;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
            return true;

       return isSubtree(root,subRoot,0);
    }
}