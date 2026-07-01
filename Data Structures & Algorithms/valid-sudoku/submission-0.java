class Solution {
    public boolean isValidSudoku(char[][] board) {
        // First traverse towards the row 

        for(int row=0;row<9;row++)
        {
            Set<Character> set=new HashSet<>();
            for(int col=0;col<9;col++)
            {
                if(board[row][col]=='.') continue;
                else if(set.contains(board[row][col])) return false;
                else{set.add(board[row][col]);}
            }

        }
        // Second traverse for all column
        for(int col=0;col<9;col++)
        {
            Set<Character> set=new HashSet<>();
            for(int row=0;row<9;row++)
            {
                if(board[row][col]=='.') continue;
                else if(set.contains(board[row][col])) return false;
                else{set.add(board[row][col]);}
            }

        }

        // Last traver for each 3*3 square box

        for(int sq=0;sq<9;sq++)
        {
            Set<Character> set=new HashSet<>();
            for(int row=0;row<3;row++)
            {
                
                for(int col=0;col<3;col++)
                {
                    int i=(sq/3)*3+row;
                    int j=(sq%3)*3+col;
                    if(board[i][j]=='.') continue;
                    else if(set.contains(board[i][j])) return false;
                    else{set.add(board[i][j]);}
                }

            }
        }
        return true;
        
    }
}
