class Solution {
    private static int inf= Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices= new int[n];
        Arrays.fill(prices,inf);
        prices[src]=0;

        for(int i=0;i<=k;i++)
        {
            int[] temp= Arrays.copyOf(prices,n);

            for(int[]f: flights)
            {
                int s= f[0];
                int d=f[1];
                int p= f[2];

                if(prices[s]==inf)
                {
                    continue;
                }
                if(prices[s]+p<temp[d])
                {
                    temp[d]= prices[s]+p;
                }
            }
            prices= temp;
        }

        return prices[dst]==inf? -1: prices[dst];

    }
}
