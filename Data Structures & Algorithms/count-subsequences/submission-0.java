class Solution {
    public int numDistinct(String s, String t) {

        Map<String, Integer> dp= new HashMap<>();
        if(s.length()<t.length())
        {
            return 0;
        }
        int count= func(s,t,0,0,dp,"");
        return count;
    }

    private int func(String s, String t, int i, int j, Map<String, Integer> dp, String sub)
    {
        if(j==t.length() && sub.equals(t))
        {
            return 1;
        }
        if((i==s.length() || j==t.length()) && !sub.equals(t))
        {
            return 0;
        }
        String key= i+"-"+j;
        int count=0;
        if(dp.containsKey(key))
        {
            return dp.get(key);
        }

        if(s.charAt(i)== t.charAt(j))
        {
            count= func(s,t,i+1,j+1,dp,sub+s.charAt(i));
        }
        count+= func(s,t,i+1,j,dp,sub);
        dp.put(key,count);
        return count;
    }
}
