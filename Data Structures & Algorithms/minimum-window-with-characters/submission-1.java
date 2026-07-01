class Solution {
    public String minWindow(String s, String t) {

        if(s.length()<t.length() || s=="")
            return "";
        Map<Character, Integer> countT= new HashMap<>();
        Map<Character,Integer> window= new HashMap<>();

        for(char c :t.toCharArray())
        {
            countT.put(c, countT.getOrDefault(c,0)+1);
        }

        int windowS=0, countTSize=countT.size();
        int len=Integer.MAX_VALUE;
        int [] res= {-1,-1};
        int i=0,j=0;
        while(j>=i && j<s.length())
        {   char x=s.charAt(j);
            window.put(x,1+window.getOrDefault(x,0));
            if(countT.containsKey(x) && window.get(x)==countT.get(x))
            {
                windowS++;
            }

            while(windowS==countTSize)
            {   
                if(len>(j-i+1))
                {
                    len=(j-i+1);
                    res[0]=i;
                    res[1]=j;
                }
                char y=s.charAt(i);
                if(countT.containsKey(y))
                {
                    window.put(y,window.get(y)-1);
                    if(countT.containsKey(y) && window.get(y)<countT.get(y))
                    {
                        windowS--;
                    }
                }
                i++;
                
            }
            j++;

        }
        return len==Integer.MAX_VALUE ? "" :s.substring(res[0],res[1]+1);
        
    }
}
