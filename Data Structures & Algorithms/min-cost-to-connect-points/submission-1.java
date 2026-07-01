class Solution {

    // sloving by prism algo
    public int minCostConnectPoints(int[][] points) {

        Map<Integer,List< int[]> > adj= new HashMap<>();

        for(int i=0;i<points.length-1;i++)
        {
            int x1= points[i][0];
            int y1= points[i][1];

            for(int j=i+1;j< points.length;j++)
            {
                int x2= points[j][0];
                int y2= points[j][1];

                int dist= Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.computeIfAbsent(i,k-> new ArrayList<>()).add(new int[]{dist,j});
                adj.computeIfAbsent(j,k-> new ArrayList<>()).add(new int[]{dist,i});
            }
        }
        int result=0;
        boolean[] visit= new boolean[points.length];
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->a[0]-b[0]);

        q.offer(new int[]{0,0});
        
        while(!q.isEmpty())
        {
            int[] cur= q.poll();
            
            if(visit[cur[1]])
            {
                continue;
            }
            visit[cur[1]]=true;
            result+=cur[0];

            for(int[] ne: adj.getOrDefault(cur[1],new ArrayList<>()))
            {
                if(visit[ne[1]])
                {
                    continue;
                }
                q.offer(new int[]{ne[0],ne[1]});
            }
            
        }

        return result;


        
    }
}
