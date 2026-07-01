class Solution {
/*
    Approach:
    use the same approach as the previous but instead of count 
    find the length of each neighbour 1 
    and then find the maximum. 

    traverse -> through the gird 
    use bfs approach to find the neighbour 1
    and find the length 
    return the maximmum one.
*/
    public int maxAreaOfIsland(int[][] grid) {

        if(grid.length<=0)  return 0;

        int n= grid.length;
        int m=grid[0].length;
        boolean[][] visit= new boolean[n][m];
        int result=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && !visit[i][j])
                {
                    int length=bfs(i,j,visit,grid);
                    result= Math.max(result,length);
                }
            }
        }
        return result; 
    }

    private int bfs(int row, int col, boolean[][] visit, int[][] grid)
    {
        Queue<int[]> q= new LinkedList<>();
        int count=1;
        q.add(new int[]{row,col});
        visit[row][col]=true;
        int[][] direction= {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty())
        {
            int[] qu= q.poll();
            for(int [] dr:direction)
            {
                int r= dr[0]+qu[0];
                int c=dr[1]+qu[1];

                if(r>=0 && r<grid.length && c>=0 && c<grid[0].length &&
                grid[r][c]==1 && !visit[r][c])
                {
                    count++;
                    visit[r][c]=true;
                    q.add(new int[]{r,c});
                }
            }
        }
        return count;
    }
}
