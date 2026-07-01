class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m= matrix.length;
        int n=matrix[0].length;
        int[][] dp= new int[m][n];
        int result= Integer.MIN_VALUE;
        for(int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dp[i][j]==-1)
                { 
                    dp[i][j]=dfs(i,j,matrix,dp);
                }
                result= Math.max(result,dp[i][j]);
            }
        }
        return result;
    }

    private int dfs(int i, int j, int[][] matrix, int[][]dp)
    {
        if(i<0 || j<0 || i== matrix.length || j== matrix[0].length)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int result=1;
        int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d:dir)
        {
            int r=d[0]+i;
            int c= d[1]+j;
            if(r>=0 && c>=0 && r<matrix.length && c< matrix[0].length && 
            matrix[i][j]<matrix[r][c])
            {
                result= Math.max(result, 1+dfs(r,c,matrix,dp));
            }
        }
        dp[i][j]=result;
        return result;

        
    }
}
