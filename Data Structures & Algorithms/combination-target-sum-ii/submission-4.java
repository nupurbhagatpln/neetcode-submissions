class Solution {
    List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(),0);
        return result;
        
    }

    private void backtrack(int[] nums, int target, List<Integer> subset, int index)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int i= index; i<nums.length;i++)
        {
            if(target<0)
            {
                break;
            }
            if(i>index && nums[i]==nums[i-1])   continue;

            subset.add(nums[i]);
            backtrack(nums, target-nums[i], subset, i+1);
            subset.remove(subset.size()-1);
        }
        return ;
    }
}
