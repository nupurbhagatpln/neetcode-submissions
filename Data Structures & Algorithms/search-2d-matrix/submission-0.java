class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row= matrix.length;
        int col=matrix[0].length;

        int top=0, bot=row-1;

        while(top<=bot)
        {
            int midRow= (top+bot)/2;

            if(target > matrix[midRow][col-1]) top=midRow+1;

            else if(target<matrix[midRow][0])   bot=midRow-1;

            else break;
        }

        if(!(top<=bot)) return false;
        
        int curRow=(top+bot)/2;
        int l=0, r=col-1;

        while(l<=r)
        {
            int m=(l+r)/2;
            if(target> matrix[curRow][m])   l=m+1;
            else if(target< matrix[curRow][m])  r=m-1;
            else    return true;
        }

        return false;   
    }
}
