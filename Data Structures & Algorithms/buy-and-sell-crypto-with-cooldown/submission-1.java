class Solution {
    Map<String,Integer> dp= new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0, prices, true);  
    }

    private int dfs(int i, int[] prices, boolean buy)
    {
        if(i>= prices.length)
        {
            return 0;
        }
        String key= i+"-"+buy;

        if(dp.containsKey(key))
        {
            return dp.get(key);
        }
        int cooldown= dfs(i+1, prices,buy);
        int result= Integer.MIN_VALUE;
        if(buy)
        {
            int t= dfs(i+1,prices,!buy)-prices[i];
            result= Math.max(t, cooldown);
            dp.put(key, result);
            return result;
        }
        else{
            int t= dfs(i+2,prices,!buy)+prices[i];
            result= Math.max(t, cooldown);
            dp.put(key, result);
            return result;
        }

    }
}
