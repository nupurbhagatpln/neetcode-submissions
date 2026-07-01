class Solution {
    /*
    Approach:
        follow recursion -> decision tree
        if pick-> dfs(i+1, arr, set, subset+nums[i])
        if not pick-> dfs(i+1,arr,set,subset)
        if(i>= arr.length())
        {
        set .add(subset)
        return;
        }
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> set= new ArrayList<>();
        List<Integer> subset= new ArrayList<>();
        dfs(0,nums,set,subset);
        return (set);
    }

    private void dfs(int i, int[] nums, List<List<Integer>> set, List<Integer> subset)
    {
        if(i== nums.length)
        {
            set.add(new ArrayList<>(subset));
            return;
        }
         // not to pick nums[i]
        dfs(i+1,nums,set,subset);
        // pick the nums[i]
        subset.add(nums[i]);
        dfs(i+1,nums,set,subset);
        int size=subset.size();
        subset.remove(size-1);
       
        return;
    }
}
