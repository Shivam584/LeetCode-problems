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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        int n=0;
        if(root==null)
            return ls;
        dq.add(root);
        while(!dq.isEmpty())
        {
            int l =dq.size();
            List<Integer> inLs= new ArrayList<>();
            for(int i=0;i<l;i++)
            {
                TreeNode node=dq.pollFirst();
                inLs.add(node.val);
                if(node.left!=null)
                dq.addLast(node.left);
                if(node.right!=null)
                dq.addLast(node.right);
            }
            if(n%2!=0)
            {
                int i=0, j= inLs.size()-1;
                while(i<j)
                {
                    int temp=inLs.get(i);
                    inLs.set(i, inLs.get(j));
                    inLs.set(j, temp);
                    i++;j--;
                }
            }
            ls.add(inLs);
            n++;
        }
        return ls;
    }
}