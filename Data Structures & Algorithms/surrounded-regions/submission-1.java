class Solution {
/*
Approach :
    1. check for what cannot be the solution of converting O to X
    for this traverse along the border side -> then found 'O'-> run dfs 
    and change "O" -> "T"
    2. run the loop and change all the "O"-> "X"
    3. run the loop and change all the "T"-> "O"
*/
    public void solve(char[][] board) {

        int m=board.length;
        int n=board[0].length;
// find the unsurrounded one and change it in "T"
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && ((i==0 || i==m-1) || (j==0 || j==n-1)))
                {
                    dfs(i,j,board);
                }
            }
        }
// traverse board the "O"-> "X"
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
// traver the board and change the "T" -> "O"
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='T')
                {
                    board[i][j]='O';
                }
            }
        }

       return;
    } 

    private void dfs(int r, int c, char[][] board)
    {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!='O')
        {
            return;
        }
        board[r][c]='T';
        dfs(r+1,c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);
        return;
    }
}

