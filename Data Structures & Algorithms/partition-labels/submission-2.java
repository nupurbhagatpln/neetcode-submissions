class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map= new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }

        List<Integer> ans= new ArrayList<>();
        int i=0;
        while(i<s.length())
        {   int st=i;
            int e=map.get(s.charAt(i));

            for(int j=st+1;j<=e;j++)
            {
                e= Math.max(e,map.get(s.charAt(j)));
            }
            ans.add(e-st+1);
            i=e+1;

        } 
        return ans;
    }
}
