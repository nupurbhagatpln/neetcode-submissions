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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)    return "";
        List<String> pre= new ArrayList<>();
        dfs(root, pre);
        String res= String.join(",", pre);
        System.out.println("string :"+res);
        return res;
    }
    private void dfs(TreeNode root, List<String> pre)
    {
        if(root== null)
        {
           pre.add("N");
            return ;
        }

        pre.add(String.valueOf(root.val));
        dfs(root.left, pre);
        dfs(root.right,pre);
        return;
    }
    int ind=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] arr = data.split(",");
        ind=0;
        return dfs2(arr);
    }
    
    private TreeNode dfs2(String[] data)
    {
        if(ind>= data.length)
        {
            return null;
        }

        if(data[ind].equals("N"))
        {
            ind ++;
            return null;
        }
        
        int val= Integer.parseInt(data[ind]);
        ind++;
        TreeNode root= new TreeNode(val);
        root.left= dfs2(data);
        root.right= dfs2(data);
        return root;

    }

}
