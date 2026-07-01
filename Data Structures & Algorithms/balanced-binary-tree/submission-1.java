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
    private int maxHeight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return (1+Math.max(maxHeight(root.left),maxHeight(root.right)));
    }
    public boolean isBalanced(TreeNode root) {

        if(root== null)
        {
            return true;
        }

        int leftN=maxHeight(root.left);
        int rightN=maxHeight(root.right);
        if(Math.abs(leftN-rightN)>1)
        {
            return false;
        }

        return (isBalanced(root.left)&& isBalanced(root.right));
        
    }
}
