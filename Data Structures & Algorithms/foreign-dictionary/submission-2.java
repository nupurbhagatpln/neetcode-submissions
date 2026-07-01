class Solution {
        Map<Character, List<Character>> adj;
        Map<Character, Integer> visit;
        StringBuilder ans;
    public String foreignDictionary(String[] words) {
        adj= new HashMap<>();
        visit= new HashMap<>();
        ans= new StringBuilder();

        for(String w: words)
        {
            for(char ch: w.toCharArray())
            {
                adj.putIfAbsent(ch, new ArrayList<>());
            }
        }

        for(int i=0;i<words.length-1;i++)
        {
            String w1= words[i];
            String w2= words[i+1];

            int min= Math.min(w1.length(), w2.length());

            if(w1.length() > w2.length() && w1.substring(0,min).equals(w2.substring(0,min)))
            {
                return "";
            }

            for(int j=0;j<min;j++)
            {
                if(w1.charAt(j)!= w2.charAt(j))
                {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for( char c: adj.keySet())
        {
            if(dfs(c))
            {
                return "";
            }
        }

        return ans.reverse().toString();
    }

    private boolean dfs(Character c)
    {
        // cycle detection
        if(visit.containsKey(c) && visit.get(c)==1)
        {
            return true;
        }
        //already visited 
        if(visit.containsKey(c) && visit.get(c)==2)
        {
            return false;
        }
        visit.put(c,1);

        for(char ch: adj.get(c))
        {
            if(dfs(ch))
            {
                return true;
            }
        }
        visit.put(c,2);
        ans.append(c);
        return false;
    }
}
