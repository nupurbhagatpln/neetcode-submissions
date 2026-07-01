class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        //  we will be keep on update all the 4 pointer 
        List<Integer> result= new ArrayList<>();
        int left=0, top=0;
        int right= matrix[0].length, bottom=matrix.length;

        while(left<right && top<bottom)
        {
            for(int i=left; i<right;i++)
            {
                result.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<bottom;i++)
            {
                result.add(matrix[i][right-1]);
            }
            right--;

            if(!(left<right && top<bottom)) break;

            for(int i=right-1;i>=left;i--)
            {
                result.add(matrix[bottom-1][i]);
            }

            bottom--;

            for(int i=bottom-1;i>=top;i--)
            {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
        
    }
}
