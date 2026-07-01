class Solution {
    public int rob(int[] nums) {
        int rob1=0, rob2=0;
        if(nums.length==1)
        {
            return nums[0];
        }
        for(int i=0;i<nums.length-1;i++)
        {
            int t= Math.max(rob1 +nums[i], rob2);
            rob1= rob2;
            rob2=t;
        }
        int p=rob2;
        rob1=0; rob2=0;
        for(int i=1;i<nums.length;i++)
        {
            int t= Math.max(rob1 +nums[i], rob2);
            rob1= rob2;
            rob2=t;
        }
        int q= rob2;

        return Math.max(p,q);
        
    }
}
