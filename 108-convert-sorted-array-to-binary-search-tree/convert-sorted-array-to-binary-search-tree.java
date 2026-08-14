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
        TreeNode makeTree(int i,int j,int[] nums)
        {
            if(i>j)
                return null;
            int mid= i+(j-i)/2;
            return new TreeNode(nums[mid],makeTree(i,mid-1,nums),makeTree(mid+1,j,nums));
        }
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(0,nums.length-1, nums);
    }
}