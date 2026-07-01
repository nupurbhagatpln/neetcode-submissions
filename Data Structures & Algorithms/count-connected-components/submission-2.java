class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int count=0;
        Set<Integer> visit= new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(!visit.contains(i))
            {
                dfs(i,adj,visit);
                count++;
            }
        }
        return count;

    }

    private void dfs(int node,List<List<Integer>> adj, Set<Integer> visit)
    {
        if(visit.contains(node))
        {
            return ;
        }
        visit.add(node);

        for(int n: adj.get(node))
        {
            dfs(n,adj,visit);
        }
        return;
    }
}
