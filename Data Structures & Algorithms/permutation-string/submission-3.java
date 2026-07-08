class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;
        int[] char1= new int[26];
        int[] char2= new int[26];
        int l=0;

        for(int i=0;i<s1.length();i++)
        {
            char1[s1.charAt(i)-'a']++;
            char2[s2.charAt(i)-'a']++;
        }

        int match=0;

        for(int i=0;i<26;i++)
        {
            match+= char1[i]==char2[i] ? 1:0;
        }

        for(int i=s1.length();i<s2.length();i++)
        {
            if(match==26)   return true;

            int in= s2.charAt(i)-'a';
            char2[in]++;
            if(char1[in]==char2[in]) {match++;}
            else if(char1[in]+1 == char2[in])  {match--;}

            in= s2.charAt(l)-'a';
            char2[in]--;
            if(char1[in]==char2[in]) {match++;}
            else if(char1[in]-1 == char2[in])  {match--;}

            l++;
            
        }
        return match==26;
        
    }
}
