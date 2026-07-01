class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        Set<Integer> dp= new HashSet<>();
        for(int n: nums)
        {
            sum+=n;
        }
        if(sum%2==1)
        {
            return false; // odd ones is not possible
        }
        int target= sum/2;
        dp.add(0);
        for(int i=nums.length-1;i>=0;i--)
        {
            Set<Integer> nextDp= new HashSet<>();
            for(int d:dp)
            {
                nextDp.add(d+nums[i]);
                nextDp.add(d);
            }
            dp=nextDp;
        }

        return dp.contains(target);
        
    }
}
