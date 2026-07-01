class Solution {
    public int maxProduct(int[] nums) {
       int res=nums[0];

       int pmax=1;
       int pmin=1;
       for(int n:nums)
       {
            int t= pmax*n;
            pmax= Math.max(Math.max(pmax*n,pmin*n),n);
            pmin= Math.min(Math.min(pmin*n,t),n);

            res= Math.max(res, pmax);
       }

        return res;
        
    }
}
