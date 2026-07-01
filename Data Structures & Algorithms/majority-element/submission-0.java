class Solution {
    public int majorityElement(int[] nums) {

      int count=0;
      int ans=nums[0];

      for(int n:nums)
      {
        if(n==ans)
        {
            count++;
        }
        else{
            if(count>0)
            {
                count--;
            }
            else{
                ans=n;
                count=1;
            }
        }
      } 
      return ans; 
        
    }
}