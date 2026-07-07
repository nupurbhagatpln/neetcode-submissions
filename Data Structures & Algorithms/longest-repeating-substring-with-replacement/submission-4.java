class Solution {
    public int characterReplacement(String s, int k) {
        int res=0;
        int l=0;
        int maxf=0;
        char[] ch= new char[26];
        for(int i=0;i<s.length();i++)
        {
           ch[s.charAt(i)-'A']++;
            maxf= Math.max(maxf,ch[s.charAt(i)-'A']);;

            if((i-l+1)-maxf>k)
            {
                ch[s.charAt(l)-'A']--;
                l++;
                maxf= Math.max(maxf,  ch[s.charAt(l)-'A']);
            }
            res= Math.max((i-l+1), res);
        }

       return res; 
    }
}
