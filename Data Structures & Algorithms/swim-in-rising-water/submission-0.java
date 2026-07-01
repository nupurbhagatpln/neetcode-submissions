class Solution {
    // dijkastra algo 
    public int swimInWater(int[][] grid) {
        int n= grid.length;

        PriorityQueue<int[]> minHeap= new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        boolean[][] visit = new boolean[n][n];
        int[][] direction= {{1,0},{0,1},{-1,0},{0,-1}};
        minHeap.offer(new int[]{grid[0][0],0,0});
        visit[0][0]=true;
        while(!minHeap.isEmpty())
        {
            int[] cur= minHeap.poll();
            if(cur[1]==n-1 && cur[2]==n-1)
            {
                return cur[0];
            }
            for(int[] dr:direction)
            {
                int r= dr[0]+cur[1];
                int c= dr[1]+cur[2];
                if(r<0 || c<0 || c==n || r==n || visit[r][c])
                {
                    continue;
                }
                visit[r][c]=true;
                minHeap.add(new int[]{Math.max(cur[0],grid[r][c]),r,c});
            }

        }
        return -1;
        
    }
}
