class Solution {
    public void sortColors(int[] nums) {
        int[] count= new int[3];

        for(int n: nums)
        {
            count[n]++;
        }
        int j=0;
        for(int i=0;i<3;i++)
        {
            int t= count[i];
            while(t>0)
            {
                nums[j]=i;
                t--;
                j++;
            }
        }
        
    }
}