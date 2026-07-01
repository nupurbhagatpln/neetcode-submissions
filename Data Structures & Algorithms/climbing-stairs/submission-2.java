class Solution {
    public int climbStairs(int n) {
        int[] memo= new int[n+1];
        Arrays.fill(memo, -1);
        return climb(n,memo);
        
    }
    private int climb(int n,int[] memo)
    {
        if(n<0)
        {
            return 0;
        }
        if(n==1 || n==0 || n==2)
        {
            memo[n]=n;
        }

        if(memo[n]!= -1)
        {
            return memo[n];
        }
        memo[n]= climb(n-1,memo)+climb(n-2,memo);
        return memo[n];
    }
}
