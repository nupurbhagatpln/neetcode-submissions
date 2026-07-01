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
    public boolean isValidBST(TreeNode root) {

        List<Integer> seq=new ArrayList<>();

        inOrderT(root, seq);
        for(int i=1;i<seq.size();i++)
        {
            if(seq.get(i)<=seq.get(i-1))
            {
                return false;
            }
        }
        return true;
        
    }
    private void inOrderT(TreeNode root, List<Integer> seq)
    {
        if(root==null)  return;

        inOrderT(root.left, seq);
        seq.add(root.val);
        inOrderT(root.right, seq);
    }
}
