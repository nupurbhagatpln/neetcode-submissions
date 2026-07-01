class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> subset= new ArrayList<>();
        backtrack(nums,target,subset,0);
        return ans;
    }

    private void backtrack(int[] nums, int target, List<Integer> subset, int i)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(i>= nums.length || target<0)
        {
            return;
        }
        subset.add(nums[i]);
        backtrack(nums,target-nums[i], subset,i);
        subset.remove(subset.size()-1);
        backtrack(nums, target,subset, i+1);
        
    }
}
