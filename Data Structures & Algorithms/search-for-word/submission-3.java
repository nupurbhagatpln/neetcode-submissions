class Solution {
    Set<Pair> set= new HashSet<>();
    public boolean exist(char[][] board, String word) {
        int rows= board.length;
        int cols= board[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(dfs(word, board,i,j,0))
                {
                    return true;
                }
            }
        }
        return false;  
    }

    private boolean dfs(String word, char[][] board, int r, int c,int i)
    {
        int rows= board.length;
        int cols= board[0].length;
        // completed the whole traverse of the word
        if(i==word.length())  return true;
        // invalid cases -> return false
        if(r<0|| c<0 || r>=rows || c>=cols
        || word.charAt(i)!= board[r][c] || set.contains(new Pair<>(r,c)))
        {
        return false;
        }

        set.add(new Pair<>(r,c));
        boolean res= dfs(word, board,r+1,c,i+1) ||
                    dfs(word, board,r-1,c,i+1) ||
                    dfs(word, board,r,c+1,i+1) ||
                    dfs(word, board,r,c-1,i+1);
        set.remove(new Pair<>(r,c));

        return res;
    }
}
