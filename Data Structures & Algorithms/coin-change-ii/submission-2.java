class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp= new int[coins.length+1][amount+1];

        for(int i=0;i<coins.length+1;i++)
        {
            dp[i][0]=1;
        }

        for(int r=coins.length-1;r>=0;r--)
        {
            for(int a=0;a<=amount;a++)
            {
                dp[r][a]= dp[r+1][a];
                if(coins[r]<=a)
                {
                    dp[r][a]+= dp[r][a-coins[r]];
                }
            }
        }
        return dp[0][amount];
        
    }
}
