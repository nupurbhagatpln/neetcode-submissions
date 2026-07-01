class Solution {
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans= new int[numCourses];
        index= numCourses-1;
        Map<Integer,List<Integer>> map= new HashMap<>();
        int[] status= new int[numCourses];
        for(int[] p:prerequisites)
        {
            map.putIfAbsent(p[1],new ArrayList<>());
            map.get(p[1]).add(p[0]);
        }
        for(int i=0 ;i< numCourses;i++)
        {
            if(!dfs(i,map,status,ans))
            {
                return new int[0];
            }
        }
        return ans;

    }

    private boolean dfs(int i, Map<Integer,List<Integer>> map, int[] status, int[] ans )
    {
        if(status[i]==1)
        {
            return false;
        }

        else if(status[i]==2)
        {
            return true;
        }

        else if(!map.containsKey(i))
        {
            status[i]=2;
           ans[index--]=i;
           return true;
        }
        status[i]=1;

        for(int n: map.get(i))
        {
            if(!dfs(n,map,status,ans))
            {
                return false;
            }
        }
        ans[index--]=i;
        status[i]=2;
        return true;
    }
}
