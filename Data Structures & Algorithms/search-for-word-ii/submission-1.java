class TrieNode{
    Map<Character, TrieNode> children;
    Boolean end;

    TrieNode()
     {
        children= new HashMap<>();
        end= false;
    }

    public void addWord(String word)
    {
        TrieNode cur= this;
        for(char ch: word.toCharArray())
        {
            cur.children.putIfAbsent(ch, new TrieNode());
            cur=cur.children.get(ch);
        }
        cur.end=true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        int m= board.length;
        int n= board[0].length;
        boolean[][] visit= new boolean[m][n];
        Set<String> result= new HashSet<>();
        TrieNode root= new TrieNode();

        for(String w: words)
        {
            root.addWord(w);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dfs(i,j,board, visit,result, root,"");
            }
        }
        
        return new ArrayList<>(result);
    }

    private void dfs(int r, int c,char[][] board,
     boolean[][] visit, Set<String> result,TrieNode root, String word)
    {
        if(r<0 || c<0 || r==board.length || c==board[0].length || visit[r][c] 
        || !root.children.containsKey(board[r][c]))
        {
            return;
        }

        visit[r][c]=true;
        word+=board[r][c];
        root=root.children.get(board[r][c]);
        if(root.end)
        {
            result.add(word);
        }

        dfs(r+1,c,board, visit,result, root,word);
        dfs(r-1,c,board, visit,result, root,word);
        dfs(r,c+1,board, visit,result, root,word);
        dfs(r,c-1,board, visit,result, root,word);

        visit[r][c]=false;
        return;

    }
}
