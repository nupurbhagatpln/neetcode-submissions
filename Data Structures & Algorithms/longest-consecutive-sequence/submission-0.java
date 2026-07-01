class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int i:nums)
        {
            set.add(i);
        }
        int longest=0;
        for(int i :nums)
        {
            if(!set.contains(i-1))
            {
                int length=1;
                while(set.contains(i+length))
                {
                    length++;
                }
                longest= Math.max(longest,length);
            }
        }

        return longest;
        
    }
}
