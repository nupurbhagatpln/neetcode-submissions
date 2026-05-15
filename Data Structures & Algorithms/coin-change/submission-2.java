class Solution {
    private final int inf= Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {

        Map<Integer, Integer> memo= new HashMap<>();
        int result=inf;

        result =coin(coins,amount,memo);
        return result==inf?-1: result;
    }

    private int coin(int[]coins, int amt, Map<Integer, Integer> memo)
    {
        if(amt==0)
        {
            return 0;
        }
        if(memo.containsKey(amt))
        {
            return memo.get(amt);
        }
        int res= inf;
        for(int c: coins)
        {
            if(c==0)    continue;
            else if(amt>=c)
            {
                int result= coin(coins,amt-c,memo);
                if(result!=inf)
                {
                    res= Math.min(result+1,res);
                }
            }
        }
        memo.put(amt, res);
        return res;
    }
}
