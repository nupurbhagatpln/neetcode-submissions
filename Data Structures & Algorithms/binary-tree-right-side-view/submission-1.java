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
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> ans= new ArrayList<>();

        List<List<Integer>> temp=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        q.add(root);
        q.add(null);
        List<Integer> t= new ArrayList<>();
        while(q.size()>0)
        {
            TreeNode cur= q.poll();
            if(cur==null)
            {
                temp.add(new ArrayList<>(t));
                if(t.size()>0)
                {
                    ans.add(t.get(t.size()-1));
                }
               
                t.clear();
                if(!q.isEmpty())
                {
                   q.add(null);
                   continue; 
                }
                else
                {
                    break;
                }
            }
            t.add(cur.val);
            if(cur.left !=null)     q.add(cur.left);
            if(cur.right !=null)    q.add(cur.right);
        }

        return ans;

        
        
    }
}
