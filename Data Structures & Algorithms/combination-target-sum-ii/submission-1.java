class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 1. same as the subset problem 
        //  but here we need to apply the conndition as per the raget value

        // 1. 
        Arrays.sort(candidates);
        Set<List<Integer>> ans= new HashSet<>();
        List<Integer> subset= new ArrayList<>();

        decisionTree(candidates, target, 0, ans, subset);
        return new ArrayList<>(ans);
    }

    private void decisionTree(int [] can, int target, int i, 
    Set<List<Integer>> ans, List<Integer> subset)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(i>=can.length || target < 0)
        {
            return;
        }

        if(target>=can[i])
        {
            subset.add(can[i]);
            decisionTree(can, target-can[i],i+1,ans, subset);
            subset.remove(subset.size()-1);
        }

        decisionTree(can, target,i+1,ans, subset);
        return;
    }
}