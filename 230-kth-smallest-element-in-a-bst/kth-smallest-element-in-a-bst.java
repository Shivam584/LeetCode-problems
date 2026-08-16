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
    public int kthSmallest(TreeNode root, int k) {
       
        Deque<TreeNode> dq =new ArrayDeque<>();
        TreeNode curr=root;
        while(curr!=null || !dq.isEmpty())
        {
            while(curr!=null)
            {
                dq.addLast(curr);
                curr=curr.left;
            }  
            curr=dq.pollLast();
            if(k==1)
                return curr.val;
            else 
                k--;
            curr=curr.right;
        }
        return -1;
    }
}