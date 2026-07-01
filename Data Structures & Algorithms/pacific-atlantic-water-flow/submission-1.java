class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n= heights[0].length;

        boolean[][] pac= new boolean[m][n];
        boolean[][] art= new boolean[m][n];

        List<List<Integer>> ans= new ArrayList<>();

        // traverse the first and last row
        for(int c=0;c<n;c++)
        {
            dfs(0,c,heights,pac,heights[0][c]);
            dfs(m-1,c,heights,art,heights[m-1][c]);
        }

        // traverse the first and last column
        for(int r=0;r<m;r++)
        {
            dfs(r,0,heights,pac,heights[r][0]);
            dfs(r,n-1,heights,art,heights[r][n-1]);
        }

        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                if(pac[r][c] && art[r][c])
                {
                    ans.add(Arrays.asList(r,c));
                }
            }
        }
        
        return ans;
    }

    // dfs function to traverse each cell

    private void dfs(int r, int c, int[][] heights,boolean[][]visit, int prev)
    {
        if(r<0 || c<0 || r==heights.length || c==heights[0].length || heights[r][c]<prev || visit[r][c])
        {
            return;
        }

        visit[r][c]=true;
        dfs(r+1,c,heights,visit,heights[r][c]);
        dfs(r,c+1,heights,visit,heights[r][c]);
        dfs(r-1,c,heights,visit,heights[r][c]);
        dfs(r,c-1,heights,visit,heights[r][c]);
    }
}
