class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        boolean[][] visit= new boolean[m][n];
        int area=0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && !visit[i][j])
                {
                    int count= dfs(i,j,grid,visit);
                    area= Math.max(count,area);
                }
            }
        }
        return area;
        
    }

    private int dfs(int r, int c, int[][] grid, boolean[][] visit)
    {
        if(r<0|| c<0 || r==grid.length || c==grid[0].length || grid[r][c]==0 || visit[r][c] )
        {
            return 0;
        }
        visit[r][c]=true;
        return 1+ dfs(r+1,c,grid,visit)+ dfs(r-1,c,grid,visit)+dfs(r,c+1,grid,visit)+dfs(r,c-1,grid,visit);
    }
}
