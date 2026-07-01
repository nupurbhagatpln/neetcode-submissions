class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map= new HashMap<>();
        int[] state = new int[numCourses];
        for(int[] t: prerequisites)
        {
            if(!map.isEmpty() && map.containsKey(t[0]))
            {
                map.get(t[0]).add(t[1]);
            }
            else{
                map.put(t[0],new ArrayList<>());
                map.get(t[0]).add(t[1]);
            }
        }
        for(int c=0; c<numCourses;c++)
        {
            if(!dfs(c,state,map))
            {
                return false;
            }
        }
        return true;
        
    }
    private boolean dfs(int c, int[] state,Map<Integer,List<Integer>>map)
    {
        if(state[c]==1) return false; //cycle detected
        if(state[c]==2) return true;    // already completed

        state[c]=1; // visited
        if(map.containsKey(c))
        {
            for(int next: map.get(c))
            {
                if(!dfs(next,state,map))
                {
                    return false;
                }
            }
        }
        state[c]=2; // completed
        return true;

        
    }
}
