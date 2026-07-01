class Solution {
    // Prims Algo:
    /*
    1. calculated the manhatten distance from each point to other points 
    starting from any source.
    2. capture all the disit in minheap , at each level pop the things out from
    min heap -> and then repaet the dist from that node to unvisited one
    3. result = cost of all the minimum dist 
    */
    public int minCostConnectPoints(int[][] points) {
        int n= points.length;
        // craeting adjaceny list to captur the dist from each node to other node 
        Map<Integer, List<int[]>> adj= new HashMap<>();

        for(int i=0;i<n;i++)
        {
            int x1= points[i][0];
            int y1= points[i][1];
            for(int j=i+1;j<n;j++)
            {
                int x2= points[j][0];
                int y2= points[j][1];
                int dist= Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.computeIfAbsent(i,k-> new ArrayList<>()).add(new int[]{dist,j});
                adj.computeIfAbsent(j,k-> new ArrayList<>()).add(new int[]{dist,i});
            }
        }
        // now prims algo

        int result=0;
        Set<Integer> visit= new HashSet<>();
        PriorityQueue<int []> minHeap= new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.offer(new int[]{0,0});
        while(visit.size()<n)
        {
            int[] cur= minHeap.poll();
            int cost= cur[0];
            int in= cur[1];
            if(visit.contains(in))
            {
                continue;
            }
            result+=cost;
            visit.add(in);

            for(int[] nei: adj.getOrDefault(in,new ArrayList<>()) )
            {
                int nCost= nei[0];
                int nInd= nei[1];
                if(!visit.contains(nInd))
                {
                    minHeap.offer(new int[]{nCost,nInd});
                }
            }

        }
        return result;
    }
}
