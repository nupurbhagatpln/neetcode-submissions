class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row= matrix.length;
        int col= matrix[0].length;

        int s= 0, e=row-1;
        int mid=0;
        while(s<=e)
        {
            mid= (s+e)/2;
            if(matrix[mid][0]> target)
            {
                e=mid-1;
            }
            else if(matrix[mid][col-1]<target)
            {
                s=mid+1;
            }
            else {
                break;
            }
        }
        s=0;
        e=col-1;
        while(s<=e)
        {
            int m= (s+e)/2;
            if(matrix[mid][m]==target)  return true;
            else if(matrix[mid][m]>target)
            {
                e=m-1;
            }
            else 
            {
                s=m+1;
            }
        }
        return false;

    }
}
