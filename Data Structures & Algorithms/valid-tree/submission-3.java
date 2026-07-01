class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();

        if(edges.length>=n)
        {
            return false;
        }

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Set<Integer> visit= new HashSet<>();
        if(!dfs(0,-1,visit,adj))
        {
            return false;
        }

        return visit.size()==n;

    }

    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj)
    {
        if(visit.contains(node))
        {
            return false;
        }
        visit.add(node);

        for(int n:adj.get(node))
        {
            if(n== parent)
            {
                continue;
            }
            else if(!dfs(n,node,visit,adj))
            {
                return false;
            }
        }

        return true;
    }
}
