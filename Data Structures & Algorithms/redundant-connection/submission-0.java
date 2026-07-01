class Solution {
/*
Approach:
    same as ealier but here we have to check for each edge
*/
    public int[] findRedundantConnection(int[][] edges) {

       List<List<Integer>> adj= new ArrayList<>();

       for(int i=0;i<=edges.length;i++)
       {
            adj.add(new ArrayList<>());
       } 

       for(int[] e: edges)
       {
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
        boolean[] visit= new boolean[edges.length+1];
        // cycle detected 
        if(dfs(e[0],-1,adj,visit))  return e;
       }
        return new int[0];
    }
    private boolean dfs(int node, int parent,
    List<List<Integer>> adj, boolean[] visit)
    {
        if(visit[node]) return true;

        visit[node]=true;

        for(int n: adj.get(node))
        {
            if(parent== n)  continue;
            if(dfs(n, node, adj, visit))
            {
                return true;
            }
        }
        return false;  // cycle not detected
    }
}
