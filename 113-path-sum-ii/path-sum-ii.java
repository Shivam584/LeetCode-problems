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
    List<List<Integer>> ls;
    List<Integer> temp;
    void getThePaths(TreeNode root, int targetSum)
    {
            if(root==null)
                return ;
            temp.add(root.val);
            if(root.val==targetSum && root.left==root.right)
            {
                ls.add(new ArrayList<>(temp));
                temp.removeLast();
                return;
            }
            getThePaths(root.left,targetSum-root.val);   
            getThePaths(root.right,targetSum-root.val);   
            temp.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         ls=new ArrayList<List<Integer>>();
         temp= new ArrayList<Integer>();
        getThePaths(root,targetSum);   
        return ls;
    }
}