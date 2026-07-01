class Solution {
    List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] pick= new boolean[nums.length];
        backtrack(nums, new ArrayList<>(),pick);
        return result; 
    }

    private void backtrack(int[] nums, List<Integer> perm, boolean[] pick)
    {
        if(perm.size()== nums.length)
        {
            result.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(!pick[i]){
                perm.add(nums[i]);
                pick[i]=true;
                backtrack(nums, perm, pick);
                perm.remove(perm.size()-1);
                pick[i]=false;
            }
        }
        return;
    }
}
