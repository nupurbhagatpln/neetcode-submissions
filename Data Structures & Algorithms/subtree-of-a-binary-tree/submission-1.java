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
    private boolean isSameTree(TreeNode root, TreeNode root2)
    {
        if(root==null && root2==null)   return true;
        if((root!=null && root2!=null)&&(root.val==root2.val))
        {
            return isSameTree(root.left,root2.left) && isSameTree(root.right,root2.right);
        }
        return false;
    } 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot==null)   return true;
        if(root==null)  return false;

        if(isSameTree(root,subRoot))    return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
