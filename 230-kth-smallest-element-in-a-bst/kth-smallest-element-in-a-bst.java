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
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)-> {
                return Integer.compare(b,a);
            }
        );
            Deque<TreeNode> dq =new ArrayDeque<TreeNode>();
        dq.addLast(root);
        while(!dq.isEmpty())
        {
            TreeNode node= dq.pollLast();
            if(node.right!=null)
                dq.addLast(node.right);
              if(node.left!=null)
                dq.addLast(node.left);
            pq.offer(node.val);
            if(pq.size()>k)
                pq.poll();      
        }
        return pq.peek();
    }
}