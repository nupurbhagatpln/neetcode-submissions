class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result= new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        
        // hashset for col:
        Set<Integer> col= new HashSet<>();
        // set for +diagonal
        Set<Integer> pdia= new HashSet<>();
        // set for -ve diagonal
        Set<Integer> ndia= new HashSet<>();

        solve(0,board,col,pdia,ndia,result);
        return result; 
    }
    private List<String> construct(char[][] board)
    {
        List<String> temp= new ArrayList<>();
        for(char[] ch: board)
        {
            temp.add(new String(ch));
        }
        return temp;

    }

    private void solve(int r,char[][] board, Set<Integer> col, 
    Set<Integer> pdia ,Set<Integer> ndia, List<List<String>> result)
    {
        int n= board.length;
        if(r==n)
        {
            result.add(construct(board));
            return;
            
        }

        for(int c=0;c<n;c++)
        {
            // checking the safeState
            // 1. column
            if(col.contains(c)|| pdia.contains(r+c) || ndia.contains(r-c))
            {
                continue;
            }
            board[r][c]='Q';
            col.add(c);
            pdia.add(r+c);
            ndia.add(r-c);

            // move to next row
            solve(r+1,board,col,pdia,ndia,result);

            // backtrack
            board[r][c]='.';
            col.remove(c);
            pdia.remove(r+c);
            ndia.remove(r-c);
        }



    }
}
