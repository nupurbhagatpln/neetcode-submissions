class Solution {
/*
Approach:
    use the same aaproach we use to find thr island 
    but what change here is to make a count -> chose the minimum one 
    return that matrix

    ds -> queue, 2d matrix
*/
    public void islandsAndTreasure(int[][] grid) {
        int inf=2147483647;

        Queue<int[]> q= new LinkedList<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    q.add(new int[]{i,j});
                }
            }
        }

        int count=1;
        int[][] dist= {{1,0},{0,1},{-1,0},{0,-1}}; 
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] cur= q.poll();

                for(int[] d:dist)
                {
                    int r=cur[0]+d[0];
                    int c= cur[1]+d[1];

                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==inf)
                    {
                        grid[r][c] = count;
                        q.add(new int[]{r,c});
                    }
                }
            }
            count++;
        }
        
    }
}
