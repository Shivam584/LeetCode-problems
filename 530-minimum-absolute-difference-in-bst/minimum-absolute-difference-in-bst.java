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

//  class Info
//  {
//     int nxtValue;
//     int prvValue;

//     Info(Integer nxt, Integer prv)
//     {
//         this.nxtValue=nxt;
//         this.prvValue=prv;
//     }

//     public void setNxtValue(int nxt)
//     {
//         this.nxtValue=nxt;
//     }

//     public void setPrvValue(int prv)
//     {
//         this.prvValue=prv;
//     }

//  }
class Solution {
    int minDiff;

        void calc(TreeNode root,int prv, int nxt)
        { 
            minDiff=Math.min(minDiff, Math.min(root.val-prv, nxt-root.val));
            if(root.left==null && root.right==null)
                return;
            if(root.left!=null)
                calc(root.left,prv,Math.min(nxt,root.val));
            if(root.right!=null)
                calc(root.right,Math.max(prv,root.val),nxt);
        }
    public int getMinimumDifference(TreeNode root) {
        minDiff=Integer.MAX_VALUE-1;
        if(root==null)
            return 0;
        calc(root,-1000001,1000001);
        return minDiff;
    }
}