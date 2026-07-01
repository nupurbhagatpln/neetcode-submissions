class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int m= prerequisites.length;
        if(m==0)
        {
            return true;
        }
        int n= prerequisites[0].length;
        Map<Integer,List<Integer>> map= new HashMap<>();

        for(int[] p:prerequisites)
        {
            map.putIfAbsent(p[1],new ArrayList<>());
            map.get(p[1]).add(p[0]);
        }

        int[] status= new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(!dfs(i,map,status))
            {
                return false;
            }            
        }
        return true;  
    }

    private boolean dfs(int i, Map<Integer,List<Integer>> map, int[] status)
    {
        if(i>= status.length || status[i]==1)
        {
            return false;
        }
        if(status[i]==2)
        {
            return true;
        }
        status[i]=1;
        if(!map.containsKey(i))
        {
            status[i]=2;
            return true;
        }
        for(int p: map.get(i))
        {
            if(!dfs(p,map,status))
            {
                return false;
            }
        }
        status[i]=2;
        return true;

    }
}
