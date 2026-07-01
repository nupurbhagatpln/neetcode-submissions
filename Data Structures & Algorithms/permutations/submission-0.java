class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> perm= new ArrayList<>();
        boolean[] pick= new boolean[nums.length];
        permutation(nums, ans, pick, perm);
        return ans;
    }

    private void permutation(int [] nums, List<List<Integer>> ans, 
    boolean[] pick, List<Integer> perm)
    {
        if(perm.size()==nums.length)
        {
            ans.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(!pick[i])
            {
                perm.add(nums[i]);
                pick[i]=true;
                permutation(nums,ans,pick,perm);
                perm.remove(perm.size()-1);
                pick[i]=false;
            }
        }
        return;

    }
}
