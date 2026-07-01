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
    private int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)  return 0;
        dfs(root); 
        return res;
    }
    private int dfs(TreeNode root)
    {
        if(root==null)  return 0;

        int leftM= Math.max(dfs(root.left),0);
        int rightM=Math.max(dfs(root.right),0);
        res=Math.max(res,root.val+leftM+rightM);// max through this point
        return root.val+Math.max(leftM,rightM); // this goes in one direction either left or right
    }
}
