class Solution {
/*
Approach:
    travers the 2d matrix- if we found "1" then:
    run the bfs -> iterative approach -> 
    to traverse the matrix along all 4 direction.
*/
    public int numIslands(char[][] grid) {
        if(grid.length<=0)
            return 0;
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean [][] visit= new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && !visit[i][j] )
                {
                    count++;
                    visit[i][j]=true;
                    bfs(i,j,visit,grid);
                }
            }
        }
        return count; 
    }

    private void bfs(int row, int col, boolean[][] visit, char[][] grid)
    {
        Queue<int[]> q= new LinkedList<>();
        int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
        q.add(new int[]{row,col});
        while(!q.isEmpty())
        {
            int[] d=q.poll();

            for(int [] dr:direction)
            {
                int r=dr[0]+d[0];
                int c=dr[1]+d[1];
                if(r>=0 && r< grid.length && c>=0 && c<grid[0].length &&
                grid[r][c]=='1' && !visit[r][c])
                {
                    q.add(new int[]{r,c});
                    visit[r][c]=true;
                }
            }
        }
    }

}
