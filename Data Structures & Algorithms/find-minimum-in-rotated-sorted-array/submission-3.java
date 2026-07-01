class Solution {
    public int findMin(int[] nums) {

        int start=0,end=nums.length-1;
        int res=Integer.MAX_VALUE;

        while(start<=end)
        {
            if(nums[start]<nums[end]) 
            {
                res=Math.min(res, nums[start]);
                break;

            }
            int mid=start +(end-start)/2;
            res=Math.min(res, nums[mid]);
            if(nums[mid]>= nums[start])
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return res;
        
    }
}
