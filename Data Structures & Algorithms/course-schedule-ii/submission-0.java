class Solution {
    /*
    Approach:
    1.create a map -> courses
    2. create a array -> unvisited, visted, cycle 
    3. if ant cycle detected then return empty array
    4. else return result array
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] state= new int[numCourses];
        List<Integer> result= new ArrayList<>();
        for(int[] t: prerequisites)
        {
            if(!map.containsKey(t[0]))
            {
                map.put(t[0],new ArrayList<>());
                map.get(t[0]).add(t[1]);
            }
            else{
                map.get(t[0]).add(t[1]);
            }
        }

        for(int i=0;i<numCourses;i++)
        {
            if(!dfs(i, state,map,result))
            {
                return new int[0];
            }
        }
        int[] ans= new int[numCourses];
        for(int i=0;i<result.size();i++)
        {
            ans[i]=result.get(i);
        }
        return ans;
        
    }

    private boolean dfs(int c, int[] state, Map<Integer,List<Integer>> map,List<Integer> result)
    {
        if(state[c]==1)    return false;
        if(state[c]==2)
        {
            return true;
        }

        state[c]=1;
        if(map.containsKey(c))
        {
            for(int next: map.get(c))
            {
                if(!dfs(next,state,map, result))
                {
                    return false;
                }
            }
        }
        state[c]=2;
        result.add(c);
        return true;
    }
}
