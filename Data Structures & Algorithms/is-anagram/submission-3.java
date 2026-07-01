class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
        {
            return false;
        }
        char[] p= new char[26];

        for(char str: s.toCharArray())
        {
            p[str-'a']++;
        }

        for(char str: t.toCharArray())
        {
            p[str-'a']--;
        }
        for(int i=0;i<26;i++)
        {
           if(p[i]!=0)
           {
            return false;
           }
        }
       
       return true;



    }
}
