class Solution {
    public void rotate(int[][] matrix) {

        // First the tranpose the matrix
        int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int t= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=t;
            } 
        }

        // replace the column 0-> n-1, 1-> n-2...

        for(int i=0;i<n/2;i++)
        {
            for(int j=0;j<n;j++)
            {
                int t= matrix[j][i];
                matrix[j][i]= matrix[j][n-1-i];
                matrix[j][n-1-i]=t;
            }
        }
        
    }
}
