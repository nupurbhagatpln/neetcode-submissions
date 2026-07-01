class Solution {
    static int inf=2147483647;
/*
Approach:

    use the same approach as the previous island question 
    but here return when reach to 0
    donot move further when its -1
*/
    public void islandsAndTreasure(int[][] grid) {
       if(grid.length<=0)   return;

        int m= grid.length;
        int n=grid[0].length;
        
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                   q.add(new int[]{i,j});
                }
            }
        }
        
        int dist = 1;
        int[][] direction= {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                for(int[] dr : direction) {
                    int r = dr[0] + curr[0];
                    int c = dr[1] + curr[1];
                    
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == inf) {
                        grid[r][c] = dist;
                        q.add(new int[]{r, c});
                    }
                }
            }
            dist++;
        }

    }
}
