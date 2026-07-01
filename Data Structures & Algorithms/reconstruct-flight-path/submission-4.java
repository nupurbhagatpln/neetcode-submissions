class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> adj= new HashMap<>();

        tickets.sort((a,b)-> a.get(1).compareTo(b.get(1)));

        for(List<String> t: tickets)
        {
            adj.putIfAbsent(t.get(0), new ArrayList<>());
            adj.get(t.get(0)).add(t.get(1));
        }

        List<String> res= new ArrayList<>();
        res.add("JFK");

        if(dfs("JFK", res, adj, tickets.size()+1))
        {
            return res;
        }

        return new ArrayList<>();
    }

    private boolean dfs(String src, List<String> res, Map<String, List<String>> adj, int len)
    {
        if(res.size()==len)
        {
            return true;
        }
        if(adj.containsKey(src))
        {
            List<String> temp= adj.get(src);
            for(int i=0;i<temp.size();i++)
            {
                String v= temp.get(i);
                res.add(v);
                adj.get(src).remove(i);
                if(dfs(v,res,adj,len))
                {
                    return true;
                }
                res.remove(res.size()-1);
                adj.get(src).add(i,v);
            }
        }

        return false;
    }
}
