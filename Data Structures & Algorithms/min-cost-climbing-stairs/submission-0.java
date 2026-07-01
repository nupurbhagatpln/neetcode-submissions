class Solution {

    // Approach
        // cost[i]= ithe floor to staircase
        // jump -> i+1 or i+2 -> syart from o index jump to 0 or 1

        // [1,2,3] -> 1 start -> +2 steps-> (0+2)
        // [1,2,1,2,1,1,1] -> 1+1+1+1 (1,2,2,2)

        // 0->(1,2)->(2,3)
        //     2->(3,4)
        // 1->(1,2)->(2,3)
        //     2->(3,4)

        // if(i>=n-1)    return i==n-1? cost[i]:0
        // if(res[i]!=-1) return res[i];

        // return res[i]= cost[i]+Math.min(call(cost,i+1),call(cost,i+2));

        int [] ans;
    public int minCostClimbingStairs(int[] cost) {
        ans=new int[cost.length+1];

        for(int i=0;i<=cost.length;i++)
        {
            ans[i]=-1;
        }
        return Math.min(dfs(cost,0),dfs(cost,1)); // [1,2,3] 
    }
    private int dfs(int[] cost, int i)
    {
        if(i>= cost.length) 
        {
            return 0;
        }
        if(ans[i]!=-1)  return ans[i];
        return ans[i]=cost[i]+Math.min(dfs(cost,i+1),dfs(cost,i+2));
    }

}



