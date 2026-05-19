class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n: nums)
        {
            sum+=n;
        }
        if(sum%2==1)
        {
            return false;
        }
        int target = sum/2;
        boolean[] dp= new boolean[target +1 ];
        dp[0]=true;

        for(int n:nums)
        {
            for(int s=target;s>=n;s--)
            {
                dp[s]=dp[s] || dp[s-n];
                if(dp[target])
                {
                    return dp[target];
                }
            }
        }
        return dp[target];
    }
}
