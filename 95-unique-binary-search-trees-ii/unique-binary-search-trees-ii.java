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
        List<TreeNode> generate(int k,int n)
        {
     
            List<TreeNode> ls =new ArrayList<>();
            if(k>n)
                ls.add(null);
            else
            {    
                for(int i=k;i<=n;i++)
                {
                    List<TreeNode> l,r;
                    l=generate(k,i-1);
                    r=generate(i+1,n);

                    for(TreeNode il : l)
                    {
                        for(TreeNode ir : r)
                        {
                            ls.add( new TreeNode(i,il,ir));
                        }
                    }
                }
            }
            return ls;
        }
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
}