class Solution {
    public int[] twoSum(int[] number, int target) {
        int i=0, j=number.length-1;
        while(i<j )
        {
            if(number[j]==(target-number[i]))
            {
                return new int[]{i+1,j+1};
            }
            if(number[j]>(target-number[i]))
            {
                j--;
            }
            else{
                i++;
            }
        }
        return new int[2];
    }
}
