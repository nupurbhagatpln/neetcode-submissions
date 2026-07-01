class Solution {

    /*
    Approach:

    since its quite similar with the previous just we have to 
    take max for to things (max(1..n-1), max(0...n-2))
    */
    public int rob(int[] nums) {

        int rob1=0,rob2=0;
        if(nums.length==1)
        {
            return nums[0];
        }
        for(int i=0;i<nums.length-1;i++)
        {
            int t= Math.max(rob1+nums[i], rob2);
            rob1=rob2;
            rob2=t;
        }
        int max1= rob2;
        rob1=0;rob2=0;


        for(int i=1;i<nums.length;i++)
        {
            int t= Math.max(rob1+nums[i], rob2);
            rob1=rob2;
            rob2=t;
        }
        return Math.max(max1,rob2);
        
    }
}
