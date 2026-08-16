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
    TreeNode createTree( Map<Integer,Integer> mpPreOrder, Map<Integer,Integer> mpPostOrder,int i,int j,int postId,int[] preorder, int[] postorder)
    {
        if(i>j)
            return null;
        if(i==j)
            return new TreeNode(preorder[i]);

        TreeNode node = new TreeNode(preorder[i]);
        int leftSubTreeIdForPreOrder=mpPreOrder.get(postorder[postId-1])-1;
        int leftSubTreeIdForPostOrder=mpPostOrder.get(preorder[i+1]);
        node.left=createTree(mpPreOrder,mpPostOrder,
            i+1,
            leftSubTreeIdForPreOrder,
            leftSubTreeIdForPostOrder,
            preorder,postorder);
        
        node.right=createTree(mpPreOrder,mpPostOrder,
            leftSubTreeIdForPreOrder+1,
            j,
            postId-1,
            preorder,postorder);
        return node;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer,Integer> mpPreOrder= new HashMap<>();
        Map<Integer,Integer> mpPostOrder= new HashMap<>();
        int n=preorder.length;
        for(int i=0;i<n;i++)
        {
            mpPreOrder.put(preorder[i],i);
            mpPostOrder.put(postorder[i],i);
        }
        return createTree(mpPreOrder,mpPostOrder,0,n-1,n-1,preorder,postorder);
    }
}
