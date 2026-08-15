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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();

        if(root==null)
            return ls;
        dq.addLast(root);
        TreeNode node = null;
        while(!dq.isEmpty())
        {
            int l=dq.size();
            for(int i=1;i<=l;i++)
            {
                node = dq.pollFirst();
                if(node.left!=null)
                    dq.addLast(node.left);
                if(node.right!=null)
                    dq.addLast(node.right);
            }
            ls.add(node.val);
        }
        return ls;
    }
}