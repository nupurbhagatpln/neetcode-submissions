class Solution {
    public int lengthOfLIS(int[] nums) {
        
       int[] dp= new int[nums.length];
       dfs(0,nums, dp);
        int result= Integer.MIN_VALUE;
       for(int d:dp)
       {
            result= Math.max(d,result);
       }
       return result;
    }

    private void dfs(int n, int[]nums, int[]dp)
    {
        if(n==nums.length-1)
        {
            dp[n]=1;
            return;
        }

        if(dp[n]!=0)
        {
            return;
        }
        dp[n]=1;
        dfs(n+1,nums, dp);

        for(int i=n+1;i<nums.length;i++)
        {
            if(nums[n]<nums[i])
            {
                dp[n]=Math.max(dp[n],1+dp[i]);
            }
        }
        return;
    }
}

