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
    TreeNode prev= null;
    int in=0;
    public int kthSmallest(TreeNode root, int k) {
        int arr[]= new int[k];
        inOrderTree(root,arr,k);
        return arr[k-1];
    }

    private void inOrderTree(TreeNode root, int[]arr,int k)
    {
        if(root==null || in>=k)
        {
            return ;
        }
        inOrderTree(root.left, arr, k);
        if(in<k )
        {
            arr[in]=root.val;
        in++;
        inOrderTree(root.right, arr, k);

        }
    }
}
