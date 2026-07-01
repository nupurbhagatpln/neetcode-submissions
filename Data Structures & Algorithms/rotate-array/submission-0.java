class Solution {
    public void rotate(int[] nums, int k) {

        int n= nums.length;
        k=k%n;

        for(int i=0,j=n-1;i<j;i++,j--)
        {
            int t= nums[i];
            nums[i]=nums[j];
            nums[j]=t;
        }

        int i=0;
        int j=k-1;

        while(i<j)
        {
            int t= nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }

        i=k;
        j=n-1;

        while(i<j)
        {
            int t= nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }

        
    }
}