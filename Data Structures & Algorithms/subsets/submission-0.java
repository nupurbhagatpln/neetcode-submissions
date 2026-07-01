class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans= new ArrayList<>();

        List<Integer> subset= new ArrayList<>();

        decisionTree(nums, 0, subset,ans);

        return ans;
        
    }

    private void decisionTree(int[] nums, int i, List<Integer> subset, List<List<Integer>> ans)
    {
        if(i>=nums.length)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        // 1. select -> moves next index
        subset.add(nums[i]);
        decisionTree(nums, i+1, subset, ans);
        // 2. unselect -> moves to next index
        subset.remove(subset.size()-1);
        decisionTree(nums,i+1,subset,ans);
        return;
    }
}
