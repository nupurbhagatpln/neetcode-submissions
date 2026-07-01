class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<edges.length+1;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] e :edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);

            boolean[] visit= new boolean[edges.length+1];

            if(dfs(e[0],-1,visit,adj))
            {
                return e;
            }
        }

        return new int[0];
    }

    private boolean dfs(int node, int parent, boolean[] visit,List<List<Integer>> adj )
    {
        if(visit[node])
        {
            return true;
        }

        visit[node]= true;

        for(int n: adj.get(node))
        {
            if(parent==n)   continue;

            if(dfs(n,node, visit, adj))
            {
                return true;
            }
        }
        return false;
    }
}
