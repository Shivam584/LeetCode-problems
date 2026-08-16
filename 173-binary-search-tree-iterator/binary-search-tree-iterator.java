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
class BSTIterator {
    TreeNode pNode;
    TreeNode root;
    boolean hasNext;

    public BSTIterator(TreeNode root) {
        this.root=root;
        
        hasNext = (root!=null);
        TreeNode node = root;

        while(root.left!=null)
            root=root.left;
        this.pNode=root;
    }
    
    public int next() {
        int val=pNode.val;
        pNode=searchNext(root,val);
        this.hasNext = (pNode!=null);
        return val;
    }
    TreeNode searchNext(TreeNode root, int mn)
    {
        if(root==null)
            return root;
        if(root.val>mn)
            {
                TreeNode l=searchNext(root.left,mn);
                return (l!=null && root.val>l.val) ? l : root;
            }
        return searchNext(root.right,mn);
    }
    public boolean hasNext() {
        return this.hasNext;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */