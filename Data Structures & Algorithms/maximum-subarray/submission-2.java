class Solution {
    public int maxSubArray(int[] nums) {
        
        int result= Integer.MIN_VALUE;

        int sum=0;

        for(int n: nums)
        {
            int t= sum+n;
            if(t>=0)
            {
                sum+=n;
                result= Math.max(result, sum);
            }
            else{
                sum=0;
                result= Math.max(result, n);
            }
            
        }
        return result;
    }
}
