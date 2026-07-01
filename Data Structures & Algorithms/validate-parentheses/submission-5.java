class Solution {
    public boolean isValid(String s) {

      Stack<Character> st= new Stack<>();
      Map<Character,Character> map= new HashMap<>();
      map.put('(',')');
      map.put('{','}');
      map.put('[',']');

      for(char ch: s.toCharArray())
      {
        if(map.containsKey(ch))
        {
          st.push(ch);
        }
        else if(!st.empty() && map.get(st.peek())==ch)
        {
          st.pop();
        }
        else
        {
          return false;
        }
      }
      return st.empty();   
    }
}
