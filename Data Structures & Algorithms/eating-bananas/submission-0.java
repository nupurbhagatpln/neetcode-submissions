class Solution {
    public int minEatingSpeed(int[] piles, int h) {

       int hrPile=h/piles.length;
       int max=0;

       for(int i=0;i<piles.length;i++)
       {
            max=Math.max(max,piles[i]);
       } 
       int start=1, end=max, res=max;

       while(start<=end)
       {
            int mid=(start+end)/2;
            long totalTime=0;
            for(int p:piles)
            {
                totalTime+=Math.ceil((double)p/mid);
               
            }
            if(totalTime<=h)
            {
                end=mid-1;
                res=mid;
            }
            else{
                start=mid+1;
            }
       }
       return res;
        
    }
}
