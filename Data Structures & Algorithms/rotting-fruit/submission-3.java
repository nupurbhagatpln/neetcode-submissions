class Solution {
    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int rotten=0,fresh=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                    grid[i][j]=0;
                    rotten++;
                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        int ans=0;
        int time=1;
        int[][] dist= {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty())
        {
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                int[] cur= q.poll();
                for(int[] d:dist)
                {
                    int r= d[0]+cur[0];
                    int c= d[1]+cur[1];

                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1 )
                    {
                        grid[r][c]=0;
                        fresh--;
                        q.add(new int[]{r,c});
                        ans=time;
                    }
                }
            }
            time++;
        }  
        return fresh==0 ?ans:-1; 
    }
}
