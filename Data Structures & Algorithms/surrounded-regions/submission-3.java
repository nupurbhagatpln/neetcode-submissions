/*
Approach :

    follow the same aporach as the ocean question ,
    we will be traversing from the edges and find the "0" 
    if found ==0 then we need to mark it "N" because this cannot be converted into "X"
    Now converted all the cell to "X" except the "N", convert "N" ones to 0
*/

class Solution {
    public void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;

        // traverse the first and last row 
        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++ )
            {
                if(r==0 || r==m-1 || c==0 ||c==n-1 )
                {
                    dfs(r,c,board);
                }
            }
        }

        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                board[r][c]= board[r][c]=='N'? 'O':'X';
            }
        }
        return;
    }

    private void dfs(int r, int c, char[][] board)
    {
        if(r<0 || c<0 || r==board.length || c== board[0].length || board[r][c]!='O' )
        {
            return;
        }
        if(board[r][c]=='O')
        {
            board[r][c]='N';
            dfs(r+1,c,board);
            dfs(r-1,c,board);
            dfs(r,c+1,board);
            dfs(r,c-1,board);
        }
    }
}
