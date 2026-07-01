class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans= new HashSet<>();
        List<Integer> subset= new ArrayList<>();
        bracktrack(nums, 0, subset,ans);
        return new ArrayList<>(ans);
    }

    private void bracktrack(int[] nums,int i, List<Integer> subset
    , Set<List<Integer>> ans)
    {
        if(i>= nums.length)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        bracktrack(nums, i+1, subset, ans);
        subset.remove(subset.size()-1);
        bracktrack(nums, i+1, subset, ans);
        return;
    }
}
