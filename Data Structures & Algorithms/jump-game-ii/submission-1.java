class Solution {
    public int jump(int[] nums) {
        int ans=0;
        int l=0, r=0;

        while(r<nums.length-1)
        {
            int j=0;
            for(int i=l;i<=r;i++)
            {
                j=Math.max(j,i+nums[i]);
            }
            l=r+1;
            r=j;
            ans++;
        }

        return ans;
        
    }
}
