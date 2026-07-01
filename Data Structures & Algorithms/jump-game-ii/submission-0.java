class Solution {

/*
    Approach:

    travers through the array 0 ...n-1;
    keep track of left l and right r pointer 
    and keep track of how fartest the jump we can make by iteration b/w l and r
    and update the l = r+1 and r=fartest;
*/
    public int jump(int[] nums) {
        int ans=0, left=0, right=0;

        while(right< nums.length-1)
        {
            int jump=0;
            for(int i=left; i<=right;i++)
            {
                jump=Math.max(jump,i+nums[i]);
            }
            left=right+1;
            right=jump;
            ans++;
        }
        return ans;
    }
}
