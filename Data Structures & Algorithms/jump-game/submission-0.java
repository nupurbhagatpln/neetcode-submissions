class Solution {
/*
    Approach:
    
    goal -> nums.length-1;

    while(n-2...0)
    {
        check (nums[i]+i>=goal) -> goal =i // checking if we can reach goal 
        from the current position
    }

*/

    public boolean canJump(int[] nums) {

        int n= nums.length-1;
        for(int i=nums.length-2;i>=0;i--)
        {
          if(n<=nums[i]+i)
          {
            n=i;
          }
        }

        return n==0;
        
    }
}
