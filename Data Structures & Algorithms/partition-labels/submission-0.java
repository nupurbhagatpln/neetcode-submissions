class Solution {
/*
    Approach:
    create a map to store the count of the letter
*/
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map= new HashMap<>();
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }

        int endindex=0, start=0;
        for(int i=0;i<s.length();i++)
        {
            int in=map.get(s.charAt(i));
            endindex= Math.max(in,endindex);
            if(endindex==i)
            {
                // System.out.print("in i"+in +" "+i);
                ans.add(i-start+1);
                start=i+1;
            }
            
        }
        return ans;
    }
}
