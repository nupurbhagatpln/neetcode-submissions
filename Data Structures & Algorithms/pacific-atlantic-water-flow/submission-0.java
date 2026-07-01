class Solution {

/*
Approach:

we are going the reverse the approach :
    we try to reach the all the cell from the PO and AO
    for this we are to 
        col 0 to n-1  (1st and last row)-> runs dfs to check how many we can reach
        row 0 to n-1 (1st and last col)-> runs dfs to check how many cell we can reach

        but here the reverse the flow cell[r][c]>prevHeight -> trverse backwards

*/
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result= new ArrayList<>();
        if(heights.length<=0 )   return result;
        int m=heights.length;
        int n= heights[0].length;
        boolean[][] pac= new boolean[m][n];
        boolean[][] art= new boolean[m][n];

        // 1st and last row 

        for(int c=0 ;c<n;c++)
        {
            dfs(0,c,pac,heights,heights[0][c]);
            dfs(m-1,c,art,heights,heights[m-1][c]);
        }

         for(int r=0; r<m;r++)
        {
            dfs(r,0,pac,heights,heights[r][0]);
            dfs(r,n-1,art,heights,heights[r][n-1]);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pac[i][j] && art[i][j])
                {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result; 
    }

    private void dfs(int r, int c,boolean[][] visit, int[][] heights, int prev)
    {
        // base condition
        if(r<0 || c<0 || r>=heights.length || c>= heights[0].length || visit[r][c] || heights[r][c]<prev )
        {
            return;
        }
        visit[r][c]=true;
        dfs(r+1, c, visit, heights, heights[r][c]);
        dfs(r-1, c, visit, heights, heights[r][c]);
        dfs(r, c+1, visit, heights, heights[r][c]);
        dfs(r, c-1, visit, heights, heights[r][c]);

        return;
    }
}
