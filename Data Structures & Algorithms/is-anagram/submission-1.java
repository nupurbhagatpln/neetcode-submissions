class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> hashMap= new HashMap<>();

        if(s.length()!=t.length())
        {
            return false;
        }
        for(int i=0;i<s.length();i++)
        {
            if(hashMap.containsKey(s.charAt(i)))
            {
                int x=hashMap.get(s.charAt(i));
                hashMap.put(s.charAt(i),++x);
            }
            else{
                 hashMap.put(s.charAt(i),1);
            }
           
        }

        for(int i=0;i<t.length();i++)
        {
            if(hashMap.containsKey(t.charAt(i)) && hashMap.get(t.charAt(i))>0)
            {
                int x=hashMap.get(t.charAt(i));
                hashMap.replace(t.charAt(i),--x);
            }
               else
                {
                    return false;
                }

        }
    return true;
    }
}
