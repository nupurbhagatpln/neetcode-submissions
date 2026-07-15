class Solution {
    public int findMin(int[] nums) {

        int n= nums.length;
        int s=0, e=n-1;
        int ans=Integer.MAX_VALUE;
        while(s<=e)
        {
            if(nums[s]< nums[e])
            {
                ans=Math.min(ans,nums[s]);
                break;
            }
            int m=s+(e-s)/2;
            ans=Math.min(ans,nums[m]);
            if( nums[s]<= nums[m])
            {
                s=m+1;    
            }
            else {
                e=m-1;
            }
        }
        return ans;
        
    }
}
