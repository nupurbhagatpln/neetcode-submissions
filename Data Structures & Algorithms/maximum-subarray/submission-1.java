class Solution {
    /*
    Approach :

    while(i=0...n-1)
    ans=max(sum,ans)

    if sum<=0-> update the start and end index    
        sum=0,

    */

    public int maxSubArray(int[] nums) {

        int ans= Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum +=nums[i];
            ans= Math.max(ans,sum);
            if(sum<0)
            {
                sum=0;
            }
        }
        return ans;
    }
}
