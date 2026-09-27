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
    int ans=0;
    int setCameras(TreeNode root)
    {
        if(root==null)
            return 2;
        int l=setCameras(root.left);
        int r=setCameras(root.right);
        if(l==0 || r==0)
        {
            ans++;
            return 1;
        }
        return (l==1 || r==1) ? 2 : 0;
    }
    
    public int minCameraCover(TreeNode root) {
        return ((setCameras(root)<1)? 1 : 0)+ans;
    }


}