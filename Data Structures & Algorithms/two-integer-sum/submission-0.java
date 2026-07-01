class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashmap=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(hashmap.containsKey(target-nums[i]))
            {
                ans[0]=hashmap.get(target-nums[i]);
                ans[1]=i;
                break;
            }
            else{
                hashmap.put(nums[i],i);
            }
        }
        return ans; 
        
    }
}
