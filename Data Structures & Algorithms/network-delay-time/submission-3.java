class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj= new HashMap<>();

        for(int[] t: times)
        {
            adj.putIfAbsent(t[0], new ArrayList<>());
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        } 

        int[] dist= new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }

        dfs(k,0,adj,dist);
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans= Math.max(ans,dist[i]);
        }

        return ans==Integer.MAX_VALUE ?-1: ans;
    }

    private void dfs(int node, int time,  Map<Integer,List<int[]>> adj,int[] dist)
    {
        if(time>=dist[node])
        {
            return;
        }
        dist[node]= time;

        if(adj.containsKey(node))
        {
            for(int[] a: adj.get(node))
            {
                dfs(a[0], time+a[1],adj,dist);
            }
        }
        return ;
    }
}
