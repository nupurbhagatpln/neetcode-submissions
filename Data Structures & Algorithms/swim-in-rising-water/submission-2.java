class Solution {
    public int swimInWater(int[][] grid) {

        int m= grid.length;
        int n= grid[0].length;

        boolean[][] visit= new boolean[m][n];
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->a[0]-b[0]);

        q.offer(new int[]{grid[0][0],0,0});
        int[][] dist={{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty())
        {
            int[] cur= q.poll();
            int r=cur[1];
            int c= cur[2];
            int val= cur[0];
            if(r==m-1 && c==n-1)
            {
                return val;
            }
            if(visit[r][c])
            {
                continue;
            }
            visit[r][c]=true;
            for(int[] d: dist)
            {
                int rn= d[0]+r;
                int cn= d[1]+c;
                if(rn<0 || cn<0 || rn==m || cn==n ||visit[rn][cn])
                {
                   continue;
                }
                 q.offer(new int[]{Math.max(val,grid[rn][cn]),rn,cn});
            }
        }

        return -1;


    }
}
