class TreeNode{
    Map<Character, TreeNode> child= new HashMap<>();
    Boolean end= false;
}

class PrefixTree {

    TreeNode root;

    public PrefixTree() {
        root= new TreeNode();
    }

    public void insert(String word) {

        TreeNode cur= root;
        for(char ch: word.toCharArray())
        {
            cur.child.putIfAbsent(ch,new TreeNode());
            cur= cur.child.get(ch);
        }
        cur.end=true;
    }

    public boolean search(String word) {

        TreeNode cur= root;
        for(char ch: word.toCharArray())
        {
            if(!cur.child.containsKey(ch))
            {
                return false;
            }
            cur=cur.child.get(ch);
        }
        return cur.end;

    }

    public boolean startsWith(String prefix) {

        TreeNode cur= root;
        for(char ch:prefix.toCharArray())
        {
            if(!cur.child.containsKey(ch))
            {
                return false;
            }
            cur= cur.child.get(ch);
        }
        return true;
    }
}
