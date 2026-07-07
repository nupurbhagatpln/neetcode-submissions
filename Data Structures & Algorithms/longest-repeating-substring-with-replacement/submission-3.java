class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map= new HashMap<>();
        int res=0;
        int l=0;
        int maxf=0;
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            maxf= Math.max(maxf, map.get(s.charAt(i)));

            while((i-l+1)-maxf>k)
            {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
                maxf= Math.max(maxf, map.get(s.charAt(l)));
            }
            res= Math.max((i-l+1), res);
        }

       return res; 
    }
}
