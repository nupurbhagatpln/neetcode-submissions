class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set= new HashSet<>();
        int l=0,res=0;
        for(int i=0; i< s.length();i++)
        {
            // removing all the previous elements from the start point
            while(set.contains(s.charAt(i)))
            {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(i));
            res=Math.max(i-l+1, res);

        }
        return res;
        
    }
}
