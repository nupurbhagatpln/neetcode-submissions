class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp= new int[nums.length];
        dfs(nums, 0, dp);
        int result=0;
        for(int n: dp)
        {
            result= Math.max(result,n);
        }
        return result;
    }

    private void dfs(int[] nums, int i, int[] dp)
    {
        if(i==nums.length-1)
        {
            dp[i]=1;
            return;
        }
        if(dp[i]!=0)
        {
            return;
        }
        dfs(nums, i+1, dp);
        dp[i]=1;
        for(int j=i+1;j<nums.length;j++)
        {
            if(nums[i]<nums[j])
            {
                dp[i]= Math.max(dp[i],1+dp[j]);
            }

        }
        
        
    }
}
