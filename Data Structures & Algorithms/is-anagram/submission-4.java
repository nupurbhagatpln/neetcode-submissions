class Solution {
    public boolean isAnagram(String s, String t) {
        char[] str1= new char[26];

        for(char ch: s.toCharArray())
        {
            str1[ch-'a']++;
        }

        for(char ch: t.toCharArray())
        {
            str1[ch-'a']--;
        }

        for(int i=0;i<26;i++)
        {
            if(str1[i]>0)
            {
                return false;
            }
        }
        return true;
    }
}
