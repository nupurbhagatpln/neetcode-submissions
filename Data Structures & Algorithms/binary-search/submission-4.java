class Solution {
    public int search(int[] nums, int target) {
        long l=0, r=nums.length-1;

        while(l<=r)
        {
            int m=(int)((l+r)/2);
            System.out.println("m val "+ m +" "+ l+" "+ r);
            if(nums[m]==target) return m;
            else if( nums[m]>target)
            {
                r=m-1;
            }
            else{
                l=m+1;
            }

        }
        return -1;
    }
}
