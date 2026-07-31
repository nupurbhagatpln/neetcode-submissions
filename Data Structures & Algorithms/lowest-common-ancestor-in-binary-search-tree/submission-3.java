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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode parent= null;
        return func(null, root, p, q);

       
    }

    private TreeNode func(TreeNode parent, TreeNode root, TreeNode p, TreeNode q)
    {
         if(p.val== root.val || q.val == root.val)
        {
            parent = root;
            return parent;
        }
        else if(p.val< root.val && q.val< root.val)
        {
            parent= root;
            return  func(parent, root.left,p,q);
        }
        else if(p.val> root.val && q.val> root.val)
        {
            parent= root;
            return func(parent, root.right,p,q);
        }
        
        return root;
        
    }
}
