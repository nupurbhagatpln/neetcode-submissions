class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo= new int[cost.length +1];
        Arrays.fill(memo, -1);
        return Math.min(climb(0,memo,cost), climb(1,memo,cost));
    }

    private int climb(int n, int[] memo, int[] cost)
    {
        if(n>= cost.length)
        {
            return 0;
        }
        if(memo[n]!= -1)
        {
            return memo[n];
        }
        return memo[n]= Math.min(climb(n+1, memo,cost), climb(n+2,memo,cost)) + cost[n];
        
    }
}
