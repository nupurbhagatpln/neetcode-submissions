class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj= new HashMap<>();

        for(int[] t: times)
        {
            adj.putIfAbsent(t[0], new ArrayList<>());
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }

        int[] dist= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)-> a[0]-b[0]);
        q.offer(new int[]{0,k});

        while(!q.isEmpty())
        {
            int[] cur= q.poll();
            int time= cur[0];
            int node = cur[1];

            if(time>=dist[node])
            {
                continue;
            }
            dist[node]=time;
            if(adj.containsKey(node))
            {
                for(int[] ne: adj.get(node))
                {
                    if((time+ne[1]) < dist[ne[0]])
                    {   
                        q.offer(new int[]{time+ ne[1],ne[0]});
                    }
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans=Math.max(ans,dist[i]);
        }

        return ans==Integer.MAX_VALUE ? -1 :ans;
        
    }
}
