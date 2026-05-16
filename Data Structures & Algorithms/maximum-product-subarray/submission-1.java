class Solution {
    public int maxProduct(int[] nums) {
        int pmax=1;
        int pmin=1;
        int res=Integer.MIN_VALUE;

        for(int n: nums)
        {
            int temp=pmax*n;
            pmax= Math.max(Math.max(pmax*n , pmin*n ), n);
            pmin= Math.min(Math.min(pmin*n,temp),n);
            res= Math.max(pmax, res);
        }

        return res;
        
    }
}
