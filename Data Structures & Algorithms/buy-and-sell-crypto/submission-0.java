class Solution {
    public int maxProfit(int[] prices) {
        int s=prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++)
        {
            if(s>prices[i])
            {
                s=prices[i]; // start changes here
            }
            else{
                ans=Math.max(ans,(prices[i]-s));
            }
        }
        return ans;
    }
}
