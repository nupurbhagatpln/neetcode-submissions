class Solution {

    // Approach:
    /*
    taking the imagination as rob1, rob2, 0,1,2,3,...n-1 
    since here the max will be always max(3) = max(arr[3]+rob1, rob2).
    here the rob1 will be the max till (0..1) and rob2 max till (0..2).
    so for 3 -> max (3+(0..1) , 0..2); since the ajacent we cannot take.

    traverse through the whole 

    */
    
    public int rob(int[] nums) {

        int rob1=0,rob2=0;

        for(int i=0;i<nums.length;i++)
        {
            int t= Math.max(rob1+nums[i], rob2);
            rob1= rob2;
            rob2=t;
        }
        return rob2;
    }
}
