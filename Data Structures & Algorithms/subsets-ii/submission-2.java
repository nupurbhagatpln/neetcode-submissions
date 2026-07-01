class Solution {
    Set<List<Integer>> result= new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);  
        return new ArrayList<>(result);      
    }

    private void backtrack(int[] nums, List<Integer> subset, int i)
    {
        if(i>= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, subset,i+1);
        subset.remove(subset.size()-1);
        backtrack(nums, subset, i+1);
    }
}
