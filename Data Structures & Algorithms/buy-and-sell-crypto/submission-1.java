class Solution {
    public int maxProfit(int[] prices) {

        int s=prices[0];
        int ans=0;

        for(int n: prices)
        {
            if(s> n)
            {
                s=n;
            }
            else
            {
                ans= Math.max(ans, n-s);
            }
        }
        return ans;
        
    }
}
