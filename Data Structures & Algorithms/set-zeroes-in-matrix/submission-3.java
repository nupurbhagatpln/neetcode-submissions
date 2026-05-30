class Solution {
    public void setZeroes(int[][] matrix) {

        // Bruth force approach: SC=O(mn)
        //  make a copy of given matrix 
        //  iterate through given matrix and make changes in copy matrix

        //  2 Approach: SC=O(m+n)
        //  make two array -> first array for tracking row for zeros 
        // another array for column zeros 
        //  then as per the both array make changes in matrix

        //  3 Approach O(1)
        // Similar to 2nd approach 
        //  the two array will be -> 1st row -> coloum , 1col-> row zerors
        //  and one more variable for temp -> for storing 1st row zero value

        int firstR=1;
        int m= matrix.length;
        int n= matrix[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    
                    matrix[0][j]=0;
                    if(i==0)
                    {
                        firstR=0;
                    }
                    else{
                        matrix[i][0]=0;
                    }
                }
            }
        }
        // checking the column zeroes
        for(int col=1;col<n;col++)
        {
            if(matrix[0][col]==0)
            {
                for(int row=1;row<m;row++)
                {
                    matrix[row][col]=0;
                }
            }
        }

        // checking for rows zeroes
        
        for(int row=1;row<m;row++)
        {
            if(matrix[row][0]==0)
            {
                for(int col=1;col<n;col++)
                {
                    matrix[row][col]=0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }
        if(firstR==0)
        {
            for(int col=0;col<n;col++)
            {
                matrix[0][col]=0;
            }
        }

        
    }
}
