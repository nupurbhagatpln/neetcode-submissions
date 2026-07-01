class Solution {
    private static int inf=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map= new HashMap<>();

        int res= inf;

        res= funct(coins,amount,map);
        return res==inf ?-1: res; 
    }
    private int funct(int[] coins, int amt, Map<Integer,Integer> map)
    {
        if(amt==0)  return 0;
        if(map.containsKey(amt))
        {
            return map.get(amt);
        }
        int res= inf;
        for(int c:coins)
        {
            if(c==0)
            {
                continue;
            }
            else if(amt>=c)
            {
                int result= funct(coins,amt-c,map);
                if(result!=inf)
                {
                    res= Math.min(1+result,res);
                }
                
            }
        }
        map.put(amt, res);
        return res;
    }
}
