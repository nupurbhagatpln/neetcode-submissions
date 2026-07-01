class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr=new int[26];
        int[] arr2=new int[26];
        int window=s1.length();

        if(s1.length()>s2.length()) return false;

        for(int i=0;i<s1.length();i++)
        {
            arr[s1.charAt(i)-'a']++;                      
            arr2[s2.charAt(i)-'a']++;                      
        }
        int matches=0,l=0;
        for(int i=0;i<26;i++)
        {
            if(arr[i]==arr2[i]) matches++;
        }

        for(int i=s1.length();i<s2.length();i++)
        {
            if(matches==26) return true;

            int in=s2.charAt(i)-'a';
            arr2[in]++;
            if(arr[in]==arr2[in])   matches++;

            else if(arr[in]+1 ==arr2[in])   matches--;

            in=s2.charAt(l)-'a';
            arr2[in]--;
            if(arr[in]==arr2[in])   matches++;
            else if(arr[in]-1 == arr2[in])    matches--;

            l++;
            
        }
        return matches==26;
    }
}
