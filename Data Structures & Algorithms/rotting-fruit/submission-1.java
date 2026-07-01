class Solution {
/*
Approach:
    same as the island approach but slight changes with the -> bfs and queue
*/
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        if(grid.length<=0)  return -1;
        int m= grid.length;
        int n=grid[0].length;
        int fresh=0;
        int time=0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)   fresh++;
                else if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] direction= {{1,0},{0,1},{-1,0},{0,-1}};

        while(fresh>0 && !q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] qu= q.poll();
                for(int[] d: direction)
                {
                    int r= d[0]+qu[0];
                    int c= d[1]+qu[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1)
                    {
                        grid[r][c]=2;
                        q.offer(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        
    return fresh==0? time:-1;
    }
    
}
