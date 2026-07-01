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

public class Codec {

    // find the preorder of the tree in serialize
    // as per thr preorder squence -> we can design a tree

    // Encodes a tree to a single string.
  
    public String serialize(TreeNode root) {
        List<String> pre= new ArrayList<>();
        dfs(root,pre);
        return String.join(",",pre);
        
    }
    private void dfs(TreeNode root, List<String> res)
    {
        if(root==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfs(root.left,res);
        dfs(root.right,res);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values= data.split(",");
        int[] i= {0};
        return dfsDeseralize(values,i);  
    }
    private TreeNode dfsDeseralize(String[] val,int[] i)
    {
        if(val[i[0]].equals("N"))
        {
            i[0]++;
            return null;
        }
        TreeNode root= new TreeNode(Integer.parseInt(val[i[0]]));
        i[0]++;
        root.left= dfsDeseralize(val,i);
        root.right=dfsDeseralize(val,i);
        return root;
    }
}
