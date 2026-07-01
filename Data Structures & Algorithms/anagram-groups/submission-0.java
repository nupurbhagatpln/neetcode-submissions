class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String,List<String>> res=new HashMap<>();
      for(String s:strs)
      {
        int[] count=new int[26];
        for(char c:s.toCharArray())
        {
            count[c-'a']++;
        }
        String countArr=Arrays.toString(count);
        res.putIfAbsent(countArr,new ArrayList<>());
        res.get(countArr).add(s);
      }
      return new ArrayList<>(res.values());
    }
}
