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
    int count=0;
    public int goodNodes(TreeNode root) {

        if(root==null)  return 0; 
        if(root!=null)
        {
            count++;
            countGoodNotes(root.left,root.val);
            countGoodNotes(root.right,root.val);
        }
        return count;
    }

    private void countGoodNotes(TreeNode root,int max)
    {
        if(root==null)
        {
            return;
        }
        if(root!=null && root.val>=max)
        {
            count++;
            max= Math.max(max,root.val);
            
        }
        countGoodNotes(root.left,max);
        countGoodNotes(root.right,max);

    }
}
