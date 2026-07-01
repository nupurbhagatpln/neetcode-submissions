public class TrieNode{
    Map<Character,TrieNode> children;
    boolean isEnd;

    TrieNode()
    {
        children= new HashMap<>();
        isEnd= false;
    }

    public void addWord(String word)
    {
        TrieNode cur= this;
        for(char c:word.toCharArray())
        {
            cur.children.putIfAbsent(c, new TrieNode());
            cur= cur.children.get(c);
        }
        cur.isEnd=true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m= board.length;
        int n= board[0].length;
        TrieNode root= new TrieNode();
        boolean[][] visit= new boolean[m][n];
        for(String w: words)
        {
            root.addWord(w);
        }
        Set<String> result= new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dfs(i,j,visit, board, root,"", result);
            }
        }

        return new ArrayList<>(result);
        
    }

    private void dfs(int row, int col,boolean[][] visit,
     char[][] board,TrieNode root, String word, Set<String> result)
    {
        if(row<0 || col<0 || row== board.length || col== board[0].length
        || visit[row][col] || !root.children.containsKey(board[row][col]))
        {
            return;
        }

        visit[row][col]=true;
        root= root.children.get(board[row][col]);
        word+=board[row][col];
        if(root.isEnd)
        {
            result.add(word);
        }
        dfs(row+1,col,visit, board,root,word,result);
        dfs(row-1,col,visit, board,root,word,result);
        dfs(row,col+1,visit, board,root,word,result);
        dfs(row,col-1,visit, board,root,word,result);

        visit[row][col]=false;
    }
}
