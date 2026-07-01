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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st= new Stack<TreeNode>();

        TreeNode cur= root;
        while(!st.isEmpty() || cur!=null)
        {
            while(cur!=null)
            {
                st.push(cur);
                cur=cur.left;
            }
            TreeNode temp= st.pop();
            k--;
            if(k==0)
            {
                return temp.val;
            }
            cur=temp.right;
        }
        return -1;
    }
}
