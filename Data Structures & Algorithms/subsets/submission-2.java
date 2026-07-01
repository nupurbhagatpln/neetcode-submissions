class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset= new ArrayList<>();
        backtrack(nums, subset, 0);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> subset, int i)
    {
        if(i>=nums.length)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        // pick the number
        subset.add(nums[i]);
        backtrack(nums,subset,i+1);
        subset.remove(subset.size()-1);
        backtrack(nums,subset,i+1);
        return;
    }
}
