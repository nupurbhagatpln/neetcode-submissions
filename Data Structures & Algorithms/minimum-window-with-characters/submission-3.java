class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())   return "";

        Map<Character, Integer> map= new HashMap<>();
        Map<Character, Integer> map2= new HashMap<>();

        for(char ch: t.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int match=0;
        int window= map.size();
        int l=0, r=0,len=Integer.MAX_VALUE;
        int[] res= {-1,-1};

        while(r>=l && r< s.length())
        {
            char ch= s.charAt(r);
            map2.put(ch, map2.getOrDefault(ch,0)+1);

            if(map.containsKey(ch) && map.get(ch)== map2.get(ch))
            {
                match++;
            }
            while(match==window)
            {
                if(len> (r-l+1))
                {
                    len= r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                char ch2= s.charAt(l);
                map2.put(ch2, map2.get(ch2)-1);
                if(map.containsKey(ch2) && map.get(ch2)> map2.get(ch2))
                {
                    match--;
                }
                l++;
            }
            r++;
        }

        return len== Integer.MAX_VALUE? "": s.substring(res[0],res[1]+1);

    }
}
