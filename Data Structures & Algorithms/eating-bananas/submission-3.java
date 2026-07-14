class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1, e=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            s=Math.min(s,piles[i]);
            e= Math.max(e, piles[i]);
        }
        int ans=Integer.MAX_VALUE;

        while(s<=e)
        {
            int m= (s+e)/2;
            int total=0;
            for(int i=0;i<piles.length;i++)
            {
                total+=Math.ceil((double)piles[i]/m);
            }
            if(total<=h)
            {
                e=m-1;
                ans= Math.min(ans,m);
            }
            else {
                s=m+1;
                
            }
        }
        return ans;
    }
}
