class Solution {
    public boolean isAnagram(String s, String t) {
        int[] store= new int[26];
        if(s.length()!= t.length())
        {
            return false;
        }

        for(int i=0;i<t.length();i++)
        {
            store[s.charAt(i)-'a']++;
            store[t.charAt(i)-'a']--;
        }

        for(int n:store)
        {
            if(n!=0)
            {
                return false;
            }
        }
        return true;

    }
}
