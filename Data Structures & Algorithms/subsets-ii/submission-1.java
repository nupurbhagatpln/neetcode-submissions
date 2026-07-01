class Solution {
    /*
      Since here we can have duplicate -> so we need to maitain a set.
      other things same as subset.  
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set= new HashSet<>();
        List<Integer> subset= new ArrayList<>();

        dfs(0,nums,set,subset);
        return new ArrayList<>(set);
    }

    private void dfs(int i, int[] nums, Set<List<Integer>> set, List<Integer> subset)
    {
        if(i== nums.length)
        {
            set.add(new ArrayList<>(subset));
            return;
        }
        // picking
        subset.add(nums[i]);
        dfs(i+1, nums, set, subset);

        // not picking
        subset.remove(subset.size()-1);
        dfs(i+1,nums,set,subset);
        return ;
    }
}
