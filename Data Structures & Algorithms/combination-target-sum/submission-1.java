class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        // Arrays.sort(nums);
        Set<List<Integer>> ans= new HashSet<>();
        List<Integer> subset= new ArrayList<>();

        decisionTree(nums, target,0,subset,ans);
        return new ArrayList<>(ans);
    }
    private void decisionTree(int [] nums, int target, int i ,
    List<Integer> subset, Set<List<Integer>> ans)
    {
        if(target ==0)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        else if(target<0 || i>= nums.length)
        {
            return;
        }

        else if(target>= nums[i])
        {
            subset.add(nums[i]);
            decisionTree(nums,target-nums[i],i,subset,ans);
            subset.remove(subset.size()-1);
        }
        decisionTree(nums,target,i+1,subset,ans);
        return;

    }
}
