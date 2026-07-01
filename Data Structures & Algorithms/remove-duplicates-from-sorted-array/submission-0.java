class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        int[] arr= new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
            {
                k++;   
            }
            else{
                arr[j]=nums[i];
                j++;
            }
        }
        for(int i=0;i<j;i++)
        {
            nums[i]=arr[i];
        }
        return j;
        
        
    }
}