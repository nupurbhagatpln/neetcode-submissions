class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int ans=0;
        Set<Character> set= new HashSet<>();

        for(int i=0;i<s.length();i++)
        {
            if(set.isEmpty() || !set.contains(s.charAt(i)) )
            {
                set.add(s.charAt(i));
            }
            else{
                ans= Math.max(set.size(),ans);
                while(l<i && set.contains(s.charAt(i)))
                {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(i));
            }
        }
        return ans=Math.max(ans, set.size());
        
    }
}
