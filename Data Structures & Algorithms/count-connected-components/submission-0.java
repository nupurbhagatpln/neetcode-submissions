class Solution {

/*
    Approach :
    1. here we donot have to care about the cycle or anything 
    2. just concern of how many componenet
    3. for this traverse through n node and find 
    4. if there are ant visit already -> donot operate 
    but if visit== false -> increase the compoennet by 1
    ... see the code
*/
    public int countComponents(int n, int[][] edges) {

        if(edges.length==0) return n;
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
        Set<Integer> visit= new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(!visit.contains(i))
            {
                ans++;
                dfs(i,-1,visit,adj);
            }
        }
        return ans;

    }
    private void dfs(int node, int parent, Set<Integer> visit,
    List<List<Integer>> adj)
    {
        if(visit.contains(node))    return;

        visit.add(node);
        for(int n: adj.get(node))
        {
            if(parent==n || visit.contains(n))   continue;
            dfs(n,node,visit,adj);
        }
        return ;
    }
}
