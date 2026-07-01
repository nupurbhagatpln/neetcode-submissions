class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0,j=nums.length-1;

        int res=nums.length;

        while(i<=j)
        {
            int m= (i+j)/2;
            System.out.println("print i,j,m "+i+j+m);
            if(target== nums[m])
            {
                return m;
            }
            else if(target< nums[m])
            {
                res=m;
                j=m-1;
            }
            else if(target > nums[m])
            {
                i=m+1;
            }
        }
        return res;

    }
}