class Solution {
    public int maxCoins(int[] nums) {
        int[] arr= new int[nums.length+2];
        int [][] dp= new int[nums.length+1][nums.length+1];
        arr[0]=1; arr[arr.length-1]=1;
        for(int i=0;i<nums.length;i++)
        {
            arr[i+1]=nums[i];
        }
        return dfs(1,nums.length,arr,dp);    
    }

    private int dfs(int l, int r, int[] arr, int[][] dp)
    {
        if(l>r) return 0;

        if(dp[l][r]!=0)
        {
            return dp[l][r];
        }
        int coins=0;
        for(int i=l;i<=r;i++)
        {
            coins=arr[l-1]*arr[i]*arr[r+1];
            coins+=dfs(l,i-1, arr, dp)+ dfs(i+1,r,arr,dp);
            dp[l][r]= Math.max(coins, dp[l][r]);
        }
        return dp[l][r];
    }
}
